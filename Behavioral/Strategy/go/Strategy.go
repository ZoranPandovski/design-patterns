package main

import (
	"fmt"
	"sort"
)

// SortingStrategy defines strategy for sorting
type SortingStrategy interface {
	// Sort sorts the interger array as per the sorting strategy
	Sort(numbers []int)
}

type AscendingSort struct {
}

func (s *AscendingSort) Sort(numbers []int) {
	fmt.Println("sorting", numbers, "in ascending order")
	sort.Slice(numbers, func(i, j int) bool {
		return numbers[i] < numbers[j]
	})
}

type DescendingSort struct {
}

func (s *DescendingSort) Sort(numbers []int) {
	fmt.Println("sorting", numbers, "in descending order")
	sort.Slice(numbers, func(i, j int) bool {
		return numbers[i] > numbers[j]
	})
}

type Sorter struct {
	strategy SortingStrategy
}

func (s *Sorter) SetSortingStratergy(strategy SortingStrategy) {
	s.strategy = strategy
}

func (s *Sorter) Sort(numbers []int) {
	s.strategy.Sort(numbers)
}

func main() {
	nums1 := []int{5, 4, 3, 2, 1}
	sorter := Sorter{strategy: &AscendingSort{}}
	sorter.Sort(nums1)
	fmt.Println(nums1)

	nums2 := []int{1, 2, 3, 4, 5}
	sorter.SetSortingStratergy(&DescendingSort{})
	sorter.Sort(nums2)
	fmt.Println(nums2)

	// prints:
	// sorting [5 4 3 2 1] in ascending order
	// [1 2 3 4 5]
	// sorting [1 2 3 4 5] in descending order
	// [5 4 3 2 1]
}
