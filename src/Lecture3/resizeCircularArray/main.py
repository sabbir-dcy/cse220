import numpy as np

class Resize():
  def __init__(self, circ):
    self.circ = circ

  def expand(self, increaseBy, start):
    brr = np.zeros(shape=len(circ) + increaseBy, dtype='int')
    index = start
    for i in range(len(self.circ)):
      brr[index] = self.circ[start]
      start = (start + 1) % len(self.circ)
      index = (index + 1) % len(brr)
    return brr


if __name__ == "__main__":
  circ = np.array([3, 4, 5, 1, 2], dtype='int')
  resize = Resize(circ)
  circ = resize.expand(2, 3)
  print(circ)
