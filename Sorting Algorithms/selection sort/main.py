arr = [1, 6, 3, 5, 2, 4]

def selection(ls):
  size = len(ls)
  # loop through the whole ls
  for i in range(size):
    # find the minimum index
    # initially minimun index is i
    min_indx = i
    for j in range(i+1, size):
      if ls[j] < ls[min_indx]:
        min_indx = j
    if i != min_indx:  # not necessary
      ls[i], ls[min_indx] = ls[min_indx], ls[i]

selection(arr)
print(arr)