def power_set(string_set):
  '''
  |string_set| (e.g cardinality) is the total number of subset
  avaiable in that particluar set
  '''
  cardinality = pow(2, len(string_set))
  sub_list = []
  for i in range(cardinality):
    binary = bin(i)[2::] # binary form of each iteration

    '''
    converting default binary to n bit binary [n == len of set]
    '''
    while len(binary) != len(string_set):
      binary = '0'+binary

    '''
    if the bit is 0 do not combine, otherwise make combination
    e.g bin of 1010 represents {AC}
        bin of 1100 represents {AB}
    '''
    subset = ''
    for j in range (len(string_set)):
      if binary[j] == str(1):
        subset += string_set[j]
    print('{{{}}}'.format(subset))  # print while iterating

string_set = ['A', 'B', 'C', 'D']
power_set(string_set)