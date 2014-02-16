package com.richardhoppes.checkers.service;

import com.richardhoppes.checkers.dao.PlayerDAO;
import com.richardhoppes.checkers.model.GamePlayer;
import com.richardhoppes.checkers.model.Player;
import com.richardhoppes.checkers.model.value.Color;

public class PlayerServiceImpl implements PlayerService {

	private PlayerDAO playerDAO;

	@Override
	public Player getPlayerByDeviceId(String deviceId) {
		return playerDAO.getPlayerByDeviceId(deviceId);
	}

	@Override
	public Player createPlayer(String deviceId) {
		Player player = getPlayerByDeviceId(deviceId);

		if (player == null)
			player = playerDAO.createPlayer(deviceId);

		return player;
	}

	@Override
	public GamePlayer createGamePlayer(Integer playerId, Integer gameId, Boolean isCreator, Color color) {
		return playerDAO.createGamePlayer(gameId, playerId, isCreator, (color == Color.BLACK), color);
	}

	public PlayerDAO getPlayerDAO() {
		return playerDAO;
	}

	public void setPlayerDAO(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}
}
