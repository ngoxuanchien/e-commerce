package repo

type UserRepo struct{}

func NewUserRepo() *UserRepo {
	return &UserRepo{}
}

// user repo u
func (ur *UserRepo) GetInfoUser() string {
	return "Chien"
}
