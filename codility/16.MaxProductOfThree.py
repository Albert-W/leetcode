# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # Implement your solution here
    sorted_a = sorted(A)  

    candidate = []
    candidate.append(sorted_a[-1] * sorted_a[-2] * sorted_a[-3])
    # candidate.append(sorted_a[-1] * sorted_a[-2] * sorted_a[0])
    candidate.append(sorted_a[-1] * sorted_a[0] * sorted_a[1])
    # candidate.append(sorted_a[0] * sorted_a[1] * sorted_a[2])

    return max(candidate)