package response

const (
	ErrorCodeSuccess      = 20001 // Success
	ErrorCodeParamInvalid = 20003 // Email is invalid
	ErrInvalidToken       = 30001 // token is invalid
)

// message
var msg = map[int]string{
	ErrorCodeSuccess:      "success",
	ErrorCodeParamInvalid: "Email is invalid",
	ErrInvalidToken:       "Token is invalid",
}
