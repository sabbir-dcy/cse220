def combination(string, l, r):
  if l==r:
    print(string)
    return
  i = l
  while i <= r:
    temp = swap(string, i, l)
    combination(temp, l+1, r)
    i += 1

def swap(string, i, l):
  str_list = list(string)
  str_list[i], str_list[l] = str_list[l], str_list[i]
  return ''.join(str_list)

# def fact(n):
#   if n == 1: return 1
#   return n * fact(n-1)

string = "MTSA"
combination(string, 0, len(string)-1)