def right_aligned_star_pyramid(n: int) -> None:
    for i in range(1, n+1):
        spaces = " " * (n - i)
        stars = "*" * i
        print(spaces+stars)

# user input
n = int(input("Enter number of rows: "))
right_aligned_star_pyramid(n)
