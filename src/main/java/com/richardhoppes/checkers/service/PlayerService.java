package com.richardhoppes.checkers.service;

import com.richardhoppes.checkers.model.GamePlayer;
import com.richardhoppes.checkers.model.Player;
import com.richardhoppes.checkers.model.value.Color;

public interface PlayerService {

	public Player getPlayerByDeviceId(String deviceId);

	public Player createPlayer(String deviceId);

	public GamePlayer createGamePlayer(Integer playerId, Integer gameId, Boolean isCreator, Color color);

}
