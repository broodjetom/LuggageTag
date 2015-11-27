ALTER TABLE `luggagetag`.`passengerluggage` 
ADD COLUMN `homo` ENUM('Gevonden', 'Verloren', 'Afgehandeld') NULL AFTER `situation`;
