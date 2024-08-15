# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(X, Y, D):
    # Implement your solution here
    if (Y - X) % D == 0 : 
        return (Y - X) // D
    return (Y - X) // D + 1