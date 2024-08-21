# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # Implement your solution here
    # Find all the peaks
    peaks = []
    l = len(A)
    for i in range(1, l - 1):
        if A[i] > A[i-1] and A[i] > A[i+1]:
            peaks.append(i)
    # print(peaks) 

    if len(peaks) == 0:
        return 0
    # Start from len(peaks) to 1 
    k = len(peaks) # The number of blocks

    def isValid(peaks, k, l):
        if l % k != 0:
            return False 
        sub_l = l // k  # The length of each block
        pos = 0
        for i in peaks:
            if i <= pos + sub_l - 1 and i >= pos:
                pos += sub_l 
        # print(pos)
        if pos == l :
            return True 
        else:
            return False

    while k > 0:
        # print(k, isValid(peaks, k, l))
        if isValid(peaks, k, l):
            return k  
        else:
            k -= 1
    return 0