/*
 *   Copyright (C) 2019 GeorgH93
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package at.pcgamingfreaks.MarriageMaster.Database;

import at.pcgamingfreaks.Database.ConnectionProvider.ConnectionProvider;
import at.pcgamingfreaks.MarriageMaster.API.Home;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;

public interface IPlatformSpecific<MARRIAGE_PLAYER extends MarriagePlayerDataBase, MARRIAGE extends MarriageDataBase, HOME extends Home>
{
	MARRIAGE_PLAYER producePlayer(final @Nullable UUID uuid, final @NotNull String name, boolean priest, final boolean sharesBackpack, final @Nullable Object databaseKey);
	MARRIAGE produceMarriage(final @NotNull MARRIAGE_PLAYER player1, final @NotNull MARRIAGE_PLAYER player2, final @Nullable MARRIAGE_PLAYER priest, final @NotNull Date weddingDate,
	                                         final @Nullable String surname, final boolean pvpEnabled, final @Nullable HOME home, final @Nullable Object databaseKey);
	HOME produceHome(final @NotNull String name, final @NotNull String world, final @Nullable String server, final double x, final double y, final double z);
	UUID uuidFromName(final @NotNull String name);
	void runAsync(@NotNull Runnable runnable, long delay);
	@Nullable ConnectionProvider getExternalConnectionProvider(final @NotNull String dbType, final @NotNull Logger logger) throws SQLException;
}