# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

# Find the minimum difference between the sum of the first part and the sum of the second part of an array.
def solution(A):
    # Implement your solution here
    # Total might be 0, A[0] might be 0  
    total = sum(A) 
    left = A[0]
    p = 1
    diff = abs(total - 2 * left)
    while p < len(A):
        if abs(total - left * 2) < diff:
            diff = abs(total - left * 2)
        left += A[p]
        p += 1
        
    return diff 