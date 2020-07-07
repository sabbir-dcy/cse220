import array as arr

def insert(arr, size, pos, data):
  for i in reversed (range(pos, size)):
    arr[i + 1] = arr[i]
  arr[pos] = data

if __name__=="__main__":
  linear = arr.array("i", [11, 22, 33, 44, 55, 66, 0, 0, 0])
  insert(linear, 6, 2, 99)
  for i in linear:
    print(i)