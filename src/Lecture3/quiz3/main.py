import array as arr

def reverse(circArr):
  start, size, circArr = toCircular(circArr)
  last = (start + size - 1) % len(circArr)
  
  for i in range(size // 2):
    circArr[start], circArr[last] = circArr[last], circArr[start]
    start += 1 % len(circArr)
    last += len(circArr) - 1
    last %= len(circArr)
  return circArr

def toCircular(circArr):
    temp = arr.array('i', len(circArr) * [0])
    size, start = 0, len(circArr) // 2 

    for i in range(len(circArr)):
      temp[start] = circArr[i]
      start = (start + 1) % len(circArr)
      if circArr[i] != 0:
        size += 1
    return start, size, temp


if __name__=="__main__":
  circ = arr.array('i', [1, 2, 3, 4, 5, 6, 0, 0, 0])
  circ = reverse(circ)
  print(circ)