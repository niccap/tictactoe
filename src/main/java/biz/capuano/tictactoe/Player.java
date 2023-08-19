package biz.capuano.tictactoe;

interface Player {
    char getMark();
    Move makeMove(Board board);
}