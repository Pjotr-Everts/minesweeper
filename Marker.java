package minesweeper;

public class Marker {

    public void checkAndPlaceNumbers(Cell[][] minefield) {
        // check corners
        checkTopLeftCorner(minefield);
        checkTopRightCorner(minefield);
        checkBottomLeftCorner(minefield);
        checkBottomRightCorner(minefield);

        // check outer rows and columns
        checkTopHorizontalRow(minefield);
        checkBottomHorizontalRow(minefield);
        checkLeftVerticalRow(minefield);
        checkRightVerticalRow(minefield);

        // check center cells
        checkCenterCells(minefield);
    }

    public void checkTopLeftCorner(Cell[][] minefield) {
        int counter = 0;
        if (!minefield[0][0].isContainsMine()) {
            if (minefield[0][1].isContainsMine()) {
                counter++;
            }
            if (minefield[1][0].isContainsMine()) {
                counter++;
            }
            if (minefield[1][1].isContainsMine()) {
                counter++;
            }
        }
        if (counter > 0) {
            minefield[0][0].setHelper(counter);
        }
    }

    public void checkTopRightCorner(Cell[][] minefield) {
        int counter = 0;
        if (!minefield[0][8].isContainsMine()) {
            if (minefield[0][7].isContainsMine()) {
                counter++;
            }
            if (minefield[1][8].isContainsMine()) {
                counter++;
            }
            if (minefield[1][7].isContainsMine()) {
                counter++;
            }
        }
        if (counter > 0) {
            minefield[0][8].setHelper(counter);
        }
    }

    public void checkBottomLeftCorner(Cell[][] minefield) {
        int counter = 0;
        if (!minefield[8][0].isContainsMine()) {
            if (minefield[7][0].isContainsMine()) {
                counter++;
            }
            if (minefield[8][1].isContainsMine()) {
                counter++;
            }
            if (minefield[7][1].isContainsMine()) {
                counter++;
            }
        }
        if (counter > 0) {
            minefield[8][0].setHelper(counter);
        }
    }

    public void checkBottomRightCorner(Cell[][] minefield) {
        int counter = 0;
        if (!minefield[8][8].isContainsMine()) {
            if (minefield[7][8].isContainsMine()) {
                counter++;
            }
            if (minefield[8][7].isContainsMine()) {
                counter++;
            }
            if (minefield[7][7].isContainsMine()) {
                counter++;
            }
        }
        if (counter > 0) {
            minefield[8][8].setHelper(counter);
        }
    }

    public void checkTopHorizontalRow(Cell[][] minefield) {
        for (int i = 1; i <= 7; i++) {
            int counter = 0;
            if (!minefield[0][i].isContainsMine()) {
                if (minefield[0][i-1].isContainsMine()) {
                    counter++;
                }
                if (minefield[0][i+1].isContainsMine()) {
                    counter++;
                }
                if (minefield[1][i].isContainsMine()) {
                    counter++;
                }
                if (minefield[1][i-1].isContainsMine()) {
                    counter++;
                }
                if (minefield[1][i+1].isContainsMine()) {
                    counter++;
                }
            }
            if (counter > 0) {
                minefield[0][i].setHelper(counter);
            }
        }
    }

    public void checkBottomHorizontalRow(Cell[][] minefield) {
        for (int i = 1; i <= 7; i++) {
            int counter = 0;
            if (!minefield[8][i].isContainsMine()) {
                if (minefield[8][i-1].isContainsMine()) {
                    counter++;
                }
                if (minefield[8][i+1].isContainsMine()) {
                    counter++;
                }
                if (minefield[7][i].isContainsMine()) {
                    counter++;
                }
                if (minefield[7][i-1].isContainsMine()) {
                    counter++;
                }
                if (minefield[7][i+1].isContainsMine()) {
                    counter++;
                }
            }
            if (counter > 0) {
                minefield[8][i].setHelper(counter);
            }
        }
    }

    public void checkLeftVerticalRow(Cell[][] minefield) {
        for (int i = 1; i <= 7; i++) {
            int counter = 0;
            if (!minefield[i][0].isContainsMine()) {
                if (minefield[i-1][0].isContainsMine()) {
                    counter++;
                }
                if (minefield[i+1][0].isContainsMine()) {
                    counter++;
                }
                if (minefield[i][1].isContainsMine()) {
                    counter++;
                }
                if (minefield[i-1][1].isContainsMine()) {
                    counter++;
                }
                if (minefield[i+1][1].isContainsMine()) {
                    counter++;
                }
            }
            if (counter > 0) {
                minefield[i][0].setHelper(counter);
            }
        }
    }

    public void checkRightVerticalRow(Cell[][] minefield) {
        for (int i = 1; i <= 7; i++) {
            int counter = 0;
            if (!minefield[i][8].isContainsMine()) {
                if (minefield[i-1][8].isContainsMine()) {
                    counter++;
                }
                if (minefield[i+1][8].isContainsMine()) {
                    counter++;
                }
                if (minefield[i][7].isContainsMine()) {
                    counter++;
                }
                if (minefield[i-1][7].isContainsMine()) {
                    counter++;
                }
                if (minefield[i+1][7].isContainsMine()) {
                    counter++;
                }
            }
            if (counter > 0) {
                minefield[i][8].setHelper(counter);
            }
        }
    }

    public void checkCenterCells(Cell[][] minefield) {
        for (int i = 1; i <= 7 ; i++) {
            for (int j = 1; j <= 7 ; j++) {
                int counter = 0;
                if (!minefield[i][j].isContainsMine()) {
                    if (minefield[i-1][j].isContainsMine()) {
                        counter++;
                    }
                    if (minefield[i-1][j+1].isContainsMine()) {
                        counter++;
                    }
                    if (minefield[i][j+1].isContainsMine()) {
                        counter++;
                    }
                    if (minefield[i+1][j+1].isContainsMine()) {
                        counter++;
                    }
                    if (minefield[i+1][j].isContainsMine()) {
                        counter++;
                    }
                    if (minefield[i+1][j-1].isContainsMine()) {
                        counter++;
                    }
                    if (minefield[i][j-1].isContainsMine()) {
                        counter++;
                    }
                    if (minefield[i-1][j-1].isContainsMine()) {
                        counter++;
                    }
                }
                if (counter > 0) {
                    minefield[i][j].setHelper(counter);
                }
            }
        }
    }

}
