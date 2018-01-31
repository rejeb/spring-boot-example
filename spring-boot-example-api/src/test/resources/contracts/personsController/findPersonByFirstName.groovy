import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return Person."

    request {
        url "/persons/jane/one"
        method GET()
    }

    response {
        status 200
        body (file("jane.json"))
    }
}
