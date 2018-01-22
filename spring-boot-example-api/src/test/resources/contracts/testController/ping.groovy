import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should return Hello pong."

	request {
		url "/ping"
		method GET()
	}

	response {
		status 200
		body (
			"Hello pong."
		)
	}
}
