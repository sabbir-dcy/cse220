import array as arr

def reverse(circArr, size, start):
  last = (start + size - 1) % len(circArr)
  i = 0
  while (i < size / 2):
    circArr[start], circArr[last] = circArr[last], circArr[start]
    start = (start + 1) % len(circArr)
    last = (last + len(circArr) - 1) % len(circArr)
    i += 1


if __name__=="__main__":
  circ = arr.array('i', [3, 4, 5, 6, 0, 0, 0, 0, 1, 2])
  reverse(circ, 6, 8)
  print(circ)