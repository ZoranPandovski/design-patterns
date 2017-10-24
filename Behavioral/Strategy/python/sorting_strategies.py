#!/usr/bin/env python2.7

class SortingStrategy:
    # Line is a sequence of points:
    def sort(self, values) : pass

# The various strategies:
class AscendingSort(SortingStrategy):
    def sort(self, values):
        return sorted(values)

class DescendingSort(SortingStrategy):
    def sort(self, values):
        return sorted(values, reverse=True)

class ListSorter:
    def __init__(self, strategy):
        self.strategy = strategy

    def sort_list(self, values):
        return self.strategy.sort(values)

    def change_strategy(self, new_strategy):
        self.strategy = new_strategy
