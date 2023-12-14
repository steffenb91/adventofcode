package org.steffenboe.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        
        String fileName = "input.txt";
        try {
            Path filePath = Paths.get(fileName);
            String pattern = String.join("\n", Files.readAllLines(filePath));

            int mirroredColumn = findMirroredColumn(pattern);
            int mirroredRow = findMirroredRow(pattern);

            if (mirroredColumn != -1) {
                System.out.println("Mirroring occurs in column: " + mirroredColumn);
            } else if (mirroredRow != -1) {
                System.out.println("Mirroring occurs in row: " + mirroredRow);
            } else {
                System.out.println("No mirroring detected in the given pattern.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static int findMirroredColumn(String pattern) {
        String[] rows = pattern.split("\n");
        int numRows = rows.length;
        int numCols = rows[0].length();

        for (int col = 0; col < numCols; col++) {
            boolean isMirrored = true;

            // Skip columns with no reflection counterpart
            if (col == 0 || col == numCols - 1) {
                continue;
            }

            for (int row = 0; row < numRows; row++) {
                char currentChar = rows[row].charAt(col);
                char mirroredChar = rows[row].charAt(numCols - col - 1);

                if (currentChar != mirroredChar) {
                    isMirrored = false;
                    break;
                }
            }

            if (isMirrored) {
                return col + 1; // Columns are 1-indexed
            }
        }

        return -1;
    }

    private static int findMirroredRow(String pattern) {
        String[] rows = pattern.split("\n");
        int numRows = rows.length;
        int numCols = rows[0].length();

        for (int row = 0; row < numRows; row++) {
            boolean isMirrored = true;

            // Skip rows with no reflection counterpart
            if (row == 0 || row == numRows - 1) {
                continue;
            }

            for (int col = 0; col < numCols; col++) {
                char currentChar = rows[row].charAt(col);
                char mirroredChar = rows[numRows - row - 1].charAt(col);

                if (currentChar != mirroredChar) {
                    isMirrored = false;
                    break;
                }
            }

            if (isMirrored) {
                return row + 1; // Rows are 1-indexed
            }
        }

        return -1;
    }
}
