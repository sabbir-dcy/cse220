def power_set(string_set):
  '''
  |string_set| (e.g cardinality) is the total number of subset
  avaiable is that particluar set
  '''
  cardinality = pow(2, len(string_set))
  sub_list = []
  for i in range(cardinality):
    binary = to_binary(i) # binary form of each iteration
    '''
    all the binary value should be of n bit, [n = len of string_set]
    e.g - binary of 2 is 10, convert this to 4 bit (0010)
    '''
    while len(binary) != len(string_set):
      binary = str(0)+binary
    '''
    if the bit is 0 dont print, otherwise print the value
    e.g bin of 1010 represents {AC}
        bin of 1100 represents {AB}
    '''
    subset = ''
    for j in range (len(string_set)):
      if binary[j] == '1':
        subset += string_set[j]
    # print('{{{}}}'.format(subset))  # print whilte iterating
    sub_list.append(subset) # return as list
  return sub_list

# decimal to binary converter method
def to_binary(number):
  if number == 0: return ''
  return to_binary(number//2) + str(number%2)

string_list = ['A', 'B', 'C', 'D']

print(sorted(power_set(string_list))) # print sorted order
for x in power_set(string_list):
  print(x)