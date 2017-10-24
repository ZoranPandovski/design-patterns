#!/usr/bin/env python2.7

from sorting_strategies import *

sorter = ListSorter(AscendingSort())
values = [1, 2, 5, 8, 6, 3, 7, 4]
print(sorter.sort_list(values))
sorter.change_strategy(DescendingSort())
print(sorter.sort_list(values))
