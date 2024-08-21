# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")
import math
def solution(A):
    # Find the index of peaks 
    l = len(A)
    if l < 3:
        return 0 
    peaks = []
    for i in range(1, l - 1):
        if A[i] > A[i - 1] and A[i] > A[i + 1]:
            peaks.append(i)
    
    if len(peaks) == 0: # Edge case - no peak
        return 0

    # [1,3,5,10]
    # Find the possible number of flags 
    def isValid(peaks, flags):
        if flags == 1 and len(peaks) >= 1:
            return True
        num = flags - 1
        pos = 0
        for i in range(1, len(peaks)):
            if peaks[i] - peaks[pos] >= flags:
                pos = i
                num -= 1
                if num == 0:
                    return True
        return False

    flags = 1 # Time out error 
    flags = int(math.sqrt(peaks[-1] - peaks[0])) + 1
   
    while flags > 0:
        # print(flags, isValid(peaks, flags))
        if not isValid(peaks, flags):
            flags -= 1
        else:
            return flags
    return 0