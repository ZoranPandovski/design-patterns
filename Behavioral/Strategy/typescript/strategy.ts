interface SorterInterface {
  sort(data: Array<number>): Array<number>
}

class BubbleSort implements SorterInterface {
  public sort(data: Array<number>): Array<number> {
    for (let i = 0; i < data.length; i++) {
      let swapped: boolean = false
      for (let j = 0; j < data.length - 1; j++) {
        if (data[j] > data[j+1]) {
          let aux = data[j]
          data[j] = data[j+1]
          data[j+1] = aux
          swapped = true
        }
      }
      if (!swapped)
        return data
    }

    return data
  }
}

class InsertionSort implements SorterInterface {
  public sort(data: Array<number>): Array<number> {
    for (let i = 1; i < data.length; i++) {
      let element = data[i]
      let j = i
      while (j > 0 && element < data[j-1]) {
        let aux = data[j-1]
        data[j-1] = data[j]
        data[j] = aux
        j -= 1
      }
    }

    return data
  }
}

class Sorter implements SorterInterface {
  private sorter: SorterInterface

  constructor(sorter: SorterInterface) {
    this.sorter = sorter
  }

  public sort(data: Array<number>): Array<number> {
    return this.sorter.sort(data)
  }
}

const data = [4, 3, 10]
let sorter: SorterInterface;

if (data.length <= 5) {
  console.log('using bubble sort...')
  sorter = new Sorter(new BubbleSort());
} else {
  console.log('using insertion sort...')
  sorter = new Sorter(new InsertionSort());
}

console.log(sorter.sort(data));
