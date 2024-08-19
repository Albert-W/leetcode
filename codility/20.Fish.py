# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A, B):
    # Implement your solution here
    stack = [] # represent the fish flowing downstream
    res = 0
    for i in range(len(A)):
        if B[i] ==0:
            if len(stack) == 0:
                res += 1
            else: 
                # compare the size of fish 
                while len(stack)>0 and A[i] > A[stack[-1]]:
                    # upstream fish eat the fish in the stack
                    stack.pop()
                if len(stack) == 0:
                    res += 1
        else:
            stack.append(i)
    return res + len(stack)