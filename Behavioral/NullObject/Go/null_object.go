package main

import "fmt"

// NullNode defines an instance with zero value
var NullNode = &Node{value:0}

// Node stores the value and left and right nodes of the tree
type Node struct {
	value int
	left  *Node
	right *Node
}

// Tree stores the root node of the tree
type Tree struct {
	root *Node
}

// NewNode creates a new node with value and left and right
func NewNode(value int, left, right *Node) *Node {
	return &Node{value:value, left: left, right: right}
}

// NewLeafNode returns a leaf node of a tree
func NewLeafNode(value int) *Node {
	return NewNode(value, NullNode, NullNode)
}

// SumTree returns the sum of values of all nodes in the tree
func SumTree(root *Node) int {
	if root == NullNode {
		return root.value
	}
	return root.value + SumTree(root.left) + SumTree(root.right)
}

func main() {
	left := NewNode(1, NewLeafNode(2), NewLeafNode(3))
	right := NewNode(10, NewLeafNode(20), NewLeafNode(30))
	root := NewNode(40, left, right)

	fmt.Println(SumTree(root))
	// prints:
	// 106
}
