package basic

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestAddOne(t *testing.T) {
	// var (
	// 	input  = 1
	// 	output = 3
	// )

	// actual := AddOne(input)
	// if actual != output {
	// 	t.Errorf("AddOne(%d), input = %d, actual = %d", input, output, actual)
	// }

	assert.Equal(t, AddOne(2), 3, "AddOne(2) should be 3")

	assert.NotEqual(t, AddOne(2), 4, "AddOne(2) should not be 4")

	assert.Nil(t, nil, nil)
}

func TestAddOne2(t *testing.T) {
	var (
		input  = 2
		output = 3
	)

	actual := AddOne2(input)
	if actual != output {
		t.Errorf("AddOne(%d), input = %d, actual = %d", input, output, actual)
	}
}

// func TestRequire(t *testing.T) {
// 	require.Equal(t, 2, 3)
// 	fmt.Println("Not executing")
// }

// func TestAssert(t *testing.T) {
// 	assert.Equal(t, 2, 3)
// 	fmt.Println("Executing")
// }
