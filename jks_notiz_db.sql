-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 25. Jun 2025 um 16:58
-- Server-Version: 10.4.32-MariaDB
-- PHP-Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `jks_notiz_db`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `benutzer`
--

CREATE TABLE `benutzer` (
  `B_ID` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `passwort` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Daten für Tabelle `benutzer`
--

INSERT INTO `benutzer` (`B_ID`, `username`, `passwort`) VALUES
(17, 'JKS-Admin', '$2a$10$szy3RIMv54oYxmCvLAVCmOoq0/7cJpXPR.hzQTN2z/ledv0pC.A32'),
(34, 'JasKri', '$2a$10$0lW64A2Za7K8VFML/CCnjezQr1e6O9OSRhHojw3zzNPGNfQhNM0Ii');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `kategorie`
--

CREATE TABLE `kategorie` (
  `KategorieID` int(11) NOT NULL,
  `Kategorien_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Daten für Tabelle `kategorie`
--

INSERT INTO `kategorie` (`KategorieID`, `Kategorien_name`) VALUES
(1, 'Arbeit'),
(2, 'Privat'),
(3, 'Studium'),
(4, 'Freizeit'),
(5, 'Sonstiges');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `notiz`
--

CREATE TABLE `notiz` (
  `NotizID` int(11) NOT NULL,
  `Titel` varchar(255) NOT NULL,
  `Inhalt` text DEFAULT NULL,
  `KategorieID` int(11) DEFAULT NULL,
  `Erstellungsdatum` timestamp NULL DEFAULT current_timestamp(),
  `UserId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Daten für Tabelle `notiz`
--

INSERT INTO `notiz` (`NotizID`, `Titel`, `Inhalt`, `KategorieID`, `Erstellungsdatum`, `UserId`) VALUES
(41, 'Koffer packen', 'Klamotten, Schuhe etc. packen.', 4, '2025-06-24 22:00:00', 34),
(42, 'Ticket mitnehmen', 'Flugticket liegt auf dem Schrank, nicht vergessen!', 4, '2025-06-24 22:00:00', 34);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `notiz_tag`
--

CREATE TABLE `notiz_tag` (
  `NotizID` int(11) NOT NULL,
  `TagID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Daten für Tabelle `notiz_tag`
--

INSERT INTO `notiz_tag` (`NotizID`, `TagID`) VALUES
(41, 4),
(42, 4);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `tag`
--

CREATE TABLE `tag` (
  `TagID` int(11) NOT NULL,
  `Bezeichnung` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Daten für Tabelle `tag`
--

INSERT INTO `tag` (`TagID`, `Bezeichnung`) VALUES
(1, 'Arbeit'),
(2, 'Einkauf'),
(3, 'Hausaufgaben'),
(4, 'Urlaub'),
(5, 'Ideen');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `benutzer`
--
ALTER TABLE `benutzer`
  ADD PRIMARY KEY (`B_ID`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indizes für die Tabelle `kategorie`
--
ALTER TABLE `kategorie`
  ADD PRIMARY KEY (`KategorieID`);

--
-- Indizes für die Tabelle `notiz`
--
ALTER TABLE `notiz`
  ADD PRIMARY KEY (`NotizID`),
  ADD KEY `KategorieID` (`KategorieID`),
  ADD KEY `fk_UserId` (`UserId`);

--
-- Indizes für die Tabelle `notiz_tag`
--
ALTER TABLE `notiz_tag`
  ADD PRIMARY KEY (`NotizID`,`TagID`),
  ADD KEY `fk_Notizen_Schlagwörter_Notizen` (`NotizID`),
  ADD KEY `fk_Notizen_Schlagwörter_Schlagwörter` (`TagID`);

--
-- Indizes für die Tabelle `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`TagID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `benutzer`
--
ALTER TABLE `benutzer`
  MODIFY `B_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT für Tabelle `kategorie`
--
ALTER TABLE `kategorie`
  MODIFY `KategorieID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT für Tabelle `notiz`
--
ALTER TABLE `notiz`
  MODIFY `NotizID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT für Tabelle `tag`
--
ALTER TABLE `tag`
  MODIFY `TagID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `notiz`
--
ALTER TABLE `notiz`
  ADD CONSTRAINT `fk_Notizen_Kategorien` FOREIGN KEY (`KategorieID`) REFERENCES `kategorie` (`KategorieID`),
  ADD CONSTRAINT `fk_UserId` FOREIGN KEY (`UserId`) REFERENCES `benutzer` (`B_ID`);

--
-- Constraints der Tabelle `notiz_tag`
--
ALTER TABLE `notiz_tag`
  ADD CONSTRAINT `fk_Notizen_Schlagwörter_Notizen` FOREIGN KEY (`NotizID`) REFERENCES `notiz` (`NotizID`),
  ADD CONSTRAINT `fk_Notizen_Schlagwörter_Schlagwörter` FOREIGN KEY (`TagID`) REFERENCES `tag` (`TagID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
