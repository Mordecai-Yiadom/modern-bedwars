package com.krousant.modernbedwars.game;

import java.util.ArrayList;
import java.util.LinkedList;

public class BedWarsGame
{
    private static final int MAX_NUM_OF_TEAMS = 16;

    private BedWarsGameState gameState;
    private final ArrayList<BedWarsTeam> TEAMS_LIST;

    public BedWarsGame()
    {
        TEAMS_LIST = new ArrayList<>(MAX_NUM_OF_TEAMS);
    }

    public BedWarsGameState gameState()
    {
        return gameState;
    }

    public void setGameState(BedWarsGameState state)
    {
        this.gameState = state;
    }

    public void init()
    {}

    public void start()
    {}

    public void end()
    {}


}
