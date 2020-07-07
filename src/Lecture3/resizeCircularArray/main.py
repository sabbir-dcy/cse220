import array as arr

class Resize():
  def __init__(self, circ):
    self.circ = circ

  def expand(self, increaseBy, start):
    brr = arr.array('i', (len(self.circ) + increaseBy) * [0])
    newIndex = natIndex = start
    for i in range(len(self.circ)):
      brr[newIndex] = self.circ[natIndex]
      natIndex = (natIndex + 1) % len(self.circ)
      newIndex = (newIndex + 1) % len(brr)
    return brr


if __name__ == "__main__":
  resize = Resize(arr.array('i',[3, 4, 5, 1, 2]))
  circ = resize.expand(2, 3)
  print(circ)
