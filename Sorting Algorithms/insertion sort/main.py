arr = [5, 4, 2, 1, 6, 3];

def insertion(arr):
  size = len(arr)
  i = 0
  while (i < size):
    temp = arr[i]
    j = i
    while (j > 0):
      if temp < arr[j-1]:
        arr[j] = arr[j-1]
        j -= 1
      else:
        break
    arr[j] = temp
    i += 1

insertion(arr)
print(arr)