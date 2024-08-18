# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # Implement your solution here
    # Get the sum of [0, i]
    # 最小平均值只能发生了2元组，三元组之中。
    # 证明：取四元组 【a,b,c,d】， 
    # if a + b < c + d, then avg(a, b) < avg(a, b, c, d)
    # if a + b > c + d, then avg(c, d) < avg(a, b, c, d)
    # so min avg slice will always be slice of 2 or 3 elements.
    sum_i = [A[0]]
    for i in range(1, len(A)):
        sum_i.append(sum_i[i-1] + A[i])
    
    min_avg = (A[0] + A[1]) / 2
    res = 0
    for i in range(len(A) - 1):
        for j in range(i+1, i + 3):
            if j < len(A):
                if (sum_i[j] - sum_i[i] + A[i]) / (j - i + 1) < min_avg:
                    min_avg = (sum_i[j] - sum_i[i] + A[i]) / (j - i + 1)
                    res = i
    return res 