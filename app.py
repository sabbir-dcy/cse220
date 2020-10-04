def palindrome_check():
  string = input('enter a word or number\n').lower()
  print('palindrome') if string == string[::-1] else print("not palindrome")

def check_pal():
  string = input('enter a word or number\n').lower()

  j = len(string)-1
  for i in range(len(string)//2):
    if string[i] != string[j]:
      print('not palindrome')
      return
    j -= 1
  print('palindrome')

check_pal()
palindrome_check()

