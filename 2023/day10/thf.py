# Sample text file content
text_content = """
..............#..........................#.....................#.....#...................#..................................#...............
.............................#.........................................................................................#..........#.........
#......................#.................................................#.....................#...........#................................
......#..............................#........................................#.............................................................
................................#...........#.........#.............................................................#.....#..........#......
..................#...................................................#...................#.................................................
............................#...............................................................................................................
........#.....#...............................................................................#...............#.............................
#...................................#.....#.........................................#.....................................................#.
..........................................................................#........................#..............#........#........#.......
.....#.....#.............#.......................#..........................................................................................
..............................#.............................#....................#......#...................................................
............................................................................................................................................
.......................................#....................................#........................................#......................
.......#................................................#..............#............................#.......................................
................#.................................................#.........................................#...............................
.....................#.........................#.....................................#......................................................
...............................................................................................#..................................#.........
.#......................................................................................................................#...................
........#...................................................................................................................................
...............................#...........#.............#...............................#...........#...................................#..
.............#.....#.............................................#.....#......................................#.............................
............................................................................................................................................
.......................#...........#.................#..............................#....................................#..................
...............................................................................#.....................................................#......
..#......#.............................#............................#..................................#........................#...........
.............................#..........................#......#...........#................................................................
....................#.........................#..................................................#..........................................
......#............................................................................................................#........................
...........................................................................................................#................#...............
#..............#...................#.............................................#........................................................#.
.........................................#.........................................................#........................................
.....................#............................................#.....................#...................................................
.................................................#......#...................................................................................
.........................................................................................................#..............#.......#...........
...............................#..................................................................................#...................#.....
..........................#.........................#...........#..............#..........#..................#..............................
..........................................#.............................#...................................................................
............#......#................................................................................#.......................................
................................................................................................................#.....#....................#
...#.........................#................#...............................................................................#.............
......................#..................................#.............................#...................#................................
.......................................................................#.....#.................#............................................
.......#..................#.........................#....................................................................................#..
..........................................................................................#....................#............................
........................................#........................#.....................................................#....................
...................#.....................................................#.......#.............................................#............
..............................#.................#...........................................................................................
..#..................................................#......#................#.............................................#.........#.....#
...........#..................................................................................#.....................#.......................
.....................................................................................................#...........................#..........
................#......................#........................................................................#...........................
............................................................................................................................................
.......#..............#............#............................#......#................#.....................................#.............
............................................#........#.........................................#............................................
..............................#..............................................................................#.......................#......
............................................................................................................................................
....................#............................................................#..............................................#...........
......................................#..............................................................#...................................#..
..........#.....................#.......................................#..............#....................................................
............................................................................................................................................
....#.....................#..................#......#.......#.................#...........................................#.................
....................................#.........................................................#....................#.............#..........
....................................................................................................#.......................................
.................................................................#........................................#.................................
..................#...................................................................................................#.....................
.........................................................................#......................#...........................................
#......................................................#...........................#............................#.........#.................
...........................#............#..........................................................................................#........
..................................................................#......................#..................................................
................#................................#...........................#..............................................................
........#.....................................................................................................................#.............
...................................#........................................................................................................
.......................#.....#................................................................................#.............................
.#...........#...........................................#.................#....................#...........................................
..........................................................................................#............#................#...................
..........................#..........#......................................................................................................
.....#...............................................................................#.....................#.....................#..........
............................................................................................................................................
..........#............#................................#.....................#..................................#..........................
...............#...................#.........................#....................................#..................................#......
............................................................................................................................................
...........................................................................................................................................#
...#.....................................................................................................#..................................
......................#.............................#..........................#..............................#.............................
..........................................#...................#..........#..........................#...............#.......................
..............................#.....................................................................................................#.......
.........................................................#................................#.................................................
...............................................#............................................................................................
..........#...........................#..............#..........................#.........................#...................#.............
#.....................................................................................#.....................................................
.....#............................................................#..........................#.................#............................
...........................#.......#..............#.................................................................#.......................
.......................................................................................................#....................................
........#..........#.....................#..................#......................#......................................#...............#.
.............#.........................................................#....................................................................
................................................................#...........................................................................
.....#.................#.................................................................#......................#.....#..........#..........
................................#......#.............#.........................................#.....#......................................
...........................................................................#.........................................................#......
..........#................#................................................................................................................
.................................................#..............................#..........................................#................
.....................................................................................#.................#.........#..........................
.......................................................................#....................................#............................#..
...............#......#....................................#................................................................................
.........#...............................#..........#..........................................................................#............
...............................................................#.................#.........#.....#......................#...................
............................#.....#.........................................................................................................
......#..........................................#.......#...........................................................................#......
..............#...................................................#........................................#......#.........................
.............................................................................#..............................................................
.....................................#................................#................................................#....................
..........#..................#..............................#.............................#.................................................
....#.....................................................................#......#............................................#.............
......................#.................................#..............................................#....................................
.............#..............................................................................................................................
..........................................#......#...............................................#..........#...............................
.........................#......#.......................................................#...............................................#...
...........................................................#.................................#...................#..........................
...#...............#..................#..............#....................#...........................................#.....................
.....................................................................#...........#..........................................#......#........
..............................#...............#.................................................#......#....................................
........#.....#.............................................................................................................................
#........................................................#.............................#.......................................#.......#....
....................#..................................................#....................................................................
..........................................#......................#..........................................................................
.........................#...........................#.............................................#............#.........#.................
.....................................................................................................................#..............#.......
..........#...................................#............................................................#..................#.............
.....#..........#...................#........................................#..............................................................
.....................................................................#.........................#.......#....................................
......................#......#..............................................................................................................
.#......#...................................................................................................................................
.................................#....................................................#...........#......................#...............#..
.................#..................................#.........#.........#...........................................................#.......
..............................................#..................................#..........................................................
...........................#..........................................................................#.........#...........................
..........................................#.................................................................................................
.....................................#...........#..................#.........................................................#.............
..................#....................................#.............................#...........#........#.............#...................
"""

# Split the text content into rows
rows = text_content.strip().split('\n')

# Create a list to store the modified rows
modified_rows = []

# Process each row
for row in rows:
    # If the row contains only ".", add a new row with the same content
    if row.count('.') == len(row):
        modified_rows.append(row)
        modified_rows.append(row)
    else:
        modified_rows.append(row)

# Transpose the matrix to process each column
transposed_rows = list(map(list, zip(*modified_rows)))

# Create a list to store the modified columns
modified_columns = []

# Process each column
for col in transposed_rows:
    # If the column contains only ".", add a new column with the same content
    if col.count('.') == len(col):
        modified_columns.append(col)
        modified_columns.append(col)
    else:
        modified_columns.append(col)

# Transpose the modified columns back to rows
final_rows = list(map(list, zip(*modified_columns)))

# Join the modified rows to form the final text content
final_text_content = '\n'.join([''.join(row) for row in final_rows])

# Print the final text content
print(final_text_content)