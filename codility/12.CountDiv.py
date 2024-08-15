# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A, B, K):
    # Implement your solution here
    # 当前后位置不确定，活动性太大，统一从0出发。 
    # A 的 Range = 【0， A）, B 的 Range = [0， B]
    if A % K == 0:
        in_A = A // K - 1
    else:
        in_A = A // K
    

    in_B = B // K
    return in_B - in_A 