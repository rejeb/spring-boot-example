#!/usr/bin/env python

import json
import os
import getopt, sys

PATH_LOG_ROOT = "/VAR/newtprod"
PATH_ROOT = "/USR/newtprod"

log_dir=PATH_LOG_ROOT
root_dir=PATH_ROOT


try:
    opts, args = getopt.getopt(sys.argv[1:], "r:j:l:", ["help", "output="])
except getopt.GetoptError, err:
    # print help information and exit:
    print str(err) # will print something like "option -a not recognized"
    usage()
    sys.exit(2)
for o, a in opts:
    if o == "-r":
        root_dir = a
    elif o == "-l":
        log_dir = a
    else:
        usage()
        sys.exit()


def usage():
    print ("Usage : -r         root path, default /USR/newtprod")
    print ("      : -j         jars path, default /VAR/newtprod/jars ")
    print ("      : -l         log path, default /VAR/newtprod ")


config_file="{}/spring_boot_conf.json".format(root_dir)

with open(config_file) as data_file:
    conf = json.load(data_file)



for service in conf["services"]:
    print ("Launching {} * {}".format(service["name"], service["nb_instances"]))
    app_root_dir="{}/{}".format(root_dir,service["app_dir"])
    jars_dir ="{}/{}/jars/*".format(root_dir,service["app_dir"])
    conf_file = "{}/{}/conf".format(root_dir,service["app_dir"])
    classpath = "{}:{}".format(jars_dir,conf_file)

    serviceMainClass = "org.springframework.boot.loader.JarLauncher"
    classpathParam="-cp {}".format(classpath)

    cmd1 = "java {} {} &".format(classpathParam, serviceMainClass)
    print "cmd1 : {}".format(cmd1)

    range_instances = range(service["nb_instances"])
    for instance in filter(lambda incr: incr % 1 == 0, range_instances):
        print ("{} start".format(instance))
        os.system(cmd1.replace("PS_ID", "{}".format(instance)))

    os.system("sleep 20000")

