-- MySQL dump 10.13  Distrib 5.7.12, for Linux (x86_64)
--
-- Host: localhost    Database: tasty_khana
-- ------------------------------------------------------
-- Server version	5.7.12-0ubuntu1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `email` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `sec_question` varchar(500) DEFAULT NULL,
  `sec_answer` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('badal@gmail.com','simran','which is fav color?','blue'),('modi@gmail.com','tea','which is your fav country?','all');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `min_price` int(11) NOT NULL,
  `value` int(11) NOT NULL,
  `exp_date` date NOT NULL,
  `rest_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--

LOCK TABLES `coupon` WRITE;
/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
INSERT INTO `coupon` VALUES (1,'coup2016','price',1650,250,'2016-05-31',2),(2,'coup2017','price',1500,250,'2016-05-31',4);
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuisines`
--

DROP TABLE IF EXISTS `cuisines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuisines` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `desc` varchar(500) NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuisines`
--

LOCK TABLES `cuisines` WRITE;
/*!40000 ALTER TABLE `cuisines` DISABLE KEYS */;
INSERT INTO `cuisines` VALUES (1,'indian','indian','./cuisine_img/indian.jpg'),(2,'italian','pasta','./cuisine_img/italic.jpg'),(3,'punjabi food','mixed','./cuisine_img/punjabi.jpg'),(4,'chinese','noodles','./cuisine_img/chinese.jpg'),(5,'north indian','lassi,pani puri,samose','./cuisine_img/north indian.jpg'),(6,'South indian','Dosa sambhar','./cuisine_img/South indian.jpg'),(7,'Maharastrian','Mumbai Special','./cuisine_img/Maharastrian.jpg'),(8,'Parsi','Traditional Food in Mumbai','./cuisine_img/Parsi.jpg'),(9,'Rajasthani','Sweet dishes are never reffered to as \"Desserts\" in Rajasthan','./cuisine_img/Rajasthani.jpg'),(10,'Italian American','All type of italian food provide here.','./cuisine_img/Italian American.jpg');
/*!40000 ALTER TABLE `cuisines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_items`
--

DROP TABLE IF EXISTS `food_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food_items` (
  `food_id` int(11) NOT NULL AUTO_INCREMENT,
  `food_name` varchar(45) NOT NULL,
  `desc` varchar(300) NOT NULL,
  `food_image` varchar(200) NOT NULL,
  `cuisine_name` varchar(100) NOT NULL,
  PRIMARY KEY (`food_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_items`
--

LOCK TABLES `food_items` WRITE;
/*!40000 ALTER TABLE `food_items` DISABLE KEYS */;
INSERT INTO `food_items` VALUES (1,'crispy kabab','tasty khana','./food_img/demo.jpg','indian'),(2,'Pasta','Spicy','./food_img/Noodles.jpg','Italian'),(3,'Dosa sambhar','Mixed of rice floor','./food_img/Dosa sambhar.jpg','South indian'),(4,'non-veg balls','Mixture of mutton and chicken','./food_img/non-veg balls.jpg','indian'),(5,'momos','mix veg','./food_img/momos.jpg','chinese'),(6,'manchurian','dry and gravy','./food_img/manchurian.jpg','chinese'),(7,'egg curry','crispy and spicy','./food_img/egg curry.jpg','indian'),(8,'Beverges','Drinks','./food_img/Beverges.jpg','Maharastrian'),(9,'Sweet and Desserts','Puran poli,modak','./food_img/Sweet and Desserts.jpg','Maharastrian'),(10,'Vermicelli','Desserts','./food_img/Vermicelli.jpg','Parsi'),(11,'bhakhra','deep fried sweet dough','./food_img/bhakhra.jpg','Parsi'),(12,'meat dishes','all types of non veg','./food_img/meat dishes.jpg','Rajasthani'),(13,'Sweet Dish','Rajasthani sweets are served before,during and after the meal.','./food_img/Sweet Dish.jpg','Rajasthani'),(14,'sauces','salt ,sweet and sour','./food_img/sauces.jpg','Italian American'),(15,'Breads and sandwiches','baked bread','./food_img/Breads and sandwiches.jpg','Italian American');
/*!40000 ALTER TABLE `food_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gallery`
--

DROP TABLE IF EXISTS `gallery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gallery` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT,
  `restaurant_id` int(11) NOT NULL,
  `caption` varchar(400) NOT NULL,
  `image_path` varchar(500) NOT NULL,
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gallery`
--

LOCK TABLES `gallery` WRITE;
/*!40000 ALTER TABLE `gallery` DISABLE KEYS */;
INSERT INTO `gallery` VALUES (1,1,'interior','./restaurant_image/1462769648145.jpg'),(2,1,'food','./restaurant_image/1462769691586.jpg'),(3,1,'mainphoto','./restaurant_image/1462769929474.jpg'),(4,1,'restpics','./restaurant_image/1462773933227.jpg'),(5,1,'tastykhana','./restaurant_image/1462773988961.jpg'),(6,2,'interoir','./restaurant_image/1462779231550.jpg'),(7,2,'Exterior tag','./restaurant_image/1462779271460.jpg'),(8,2,'mainphoto','./restaurant_image/1462779298643.jpg'),(9,2,'food','./restaurant_image/1462779329843.jpg'),(10,3,'Exterior','./restaurant_image/1462779446949.jpg'),(11,3,'entrance','./restaurant_image/1462779489237.jpg'),(12,3,'food','./restaurant_image/1462779520862.jpg'),(13,3,'interior','./restaurant_image/1462779547862.jpg'),(14,4,'Exterior tag','./restaurant_image/1462779684971.jpg'),(15,4,'food','./restaurant_image/1462779722977.jpg'),(16,4,'food','./restaurant_image/1462779760205.jpg'),(17,4,'mainphoto','./restaurant_image/1462779845940.jpg'),(18,5,'mainphoto','./restaurant_image/1462780107260.jpg'),(19,5,'interior','./restaurant_image/1462780142221.jpg'),(20,5,'entrance','./restaurant_image/1462780190558.jpg'),(21,5,'food','./restaurant_image/1462780227345.jpg'),(22,6,'mainphoto','./restaurant_image/1462780360816.jpg'),(23,6,'food','./restaurant_image/1462780390676.jpg'),(24,6,'interior','./restaurant_image/1462780417800.jpg'),(25,6,'entrance','./restaurant_image/1462780484625.jpg'),(26,7,'mainphoto','./restaurant_image/1462780540459.jpg'),(27,7,'interior','./restaurant_image/1462780569986.jpg'),(28,7,'food','./restaurant_image/1462780603852.jpg'),(29,7,'Exterior','./restaurant_image/1462780654768.jpg'),(30,8,'mainphoto','./restaurant_image/1462780813809.jpg'),(32,8,'food','./restaurant_image/1462781728507.jpg'),(33,8,'interior','./restaurant_image/1462781773427.jpg'),(34,8,'mainphoto','./restaurant_image/1462781799627.jpg'),(35,15,'mainphoto','./restaurant_image/1462781847499.jpg'),(36,15,'m','./restaurant_image/1462782282200.jpg'),(37,15,'Exterior tag','./restaurant_image/1462782307959.jpg'),(38,15,'interior','./restaurant_image/1462782328920.jpg'),(39,15,'food','./restaurant_image/1462782356970.jpg'),(40,16,'mainphoto','./restaurant_image/1462782476696.jpg'),(41,16,'Exterior tag','./restaurant_image/1462782499979.jpg'),(42,16,'interior','./restaurant_image/1462782522250.jpg'),(43,16,'image','./restaurant_image/1462782546858.jpg'),(44,13,'mainphoto','./restaurant_image/1462782581948.jpg'),(45,13,'interior','./restaurant_image/1462782693312.jpg'),(46,13,'food','./restaurant_image/1462782713386.jpg'),(47,13,'Exterior','./restaurant_image/1462782746084.jpg'),(48,14,'food','./restaurant_image/1462782854390.jpg'),(49,14,'mainphoto','./restaurant_image/1462782889587.jpg'),(50,14,'entrance','./restaurant_image/1462782919949.jpg'),(51,14,'interior','./restaurant_image/1462782952724.jpg'),(52,9,'mainphoto','./restaurant_image/1462783029731.jpg'),(54,9,'interoir','./restaurant_image/1462783285937.jpg'),(55,9,'mainphoto','./restaurant_image/1462783326657.jpg'),(56,9,'mainphoto','./restaurant_image/1462783326858.jpg'),(57,9,'Exterior','./restaurant_image/1462783355578.jpg'),(58,10,'mainphoto','./restaurant_image/1462783631945.jpg'),(59,10,'Exterior tag','./restaurant_image/1462783653301.jpg'),(60,10,'interior','./restaurant_image/1462783675318.jpg'),(61,10,'food','./restaurant_image/1462783721495.jpg'),(62,11,'mainphoto','./restaurant_image/1462783848863.jpg'),(63,11,'interior','./restaurant_image/1462783890765.jpg'),(64,11,'interior','./restaurant_image/1462783995140.jpg'),(65,11,'image','./restaurant_image/1462784045038.jpg'),(66,12,'interior','./restaurant_image/1462784356793.jpg'),(67,12,'extrior','./restaurant_image/1462784396040.jpg'),(68,12,'khana','./restaurant_image/1462784449416.jpg'),(69,11,'food','./restaurant_image/1462784485516.jpg'),(70,12,'food','./restaurant_image/1462784565052.jpg');
/*!40000 ALTER TABLE `gallery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(45) NOT NULL,
  `menu_image` varchar(45) NOT NULL,
  `r_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Soups','./menu_images/1460704489644.jpg','1'),(2,'Pizza','./menu_images/1460704598796.jpg','1'),(3,'Sea food','./menu_images/1460704642032.jpg','1'),(4,'Bakingrecipies','./menu_images/1460784745571.jpg','2'),(5,'Punjabi food','./menu_images/1460787258495.jpg','2'),(6,'Snacks','./menu_images/1460787324477.jpg','3'),(7,'Gujarati food','./menu_images/1460787496837.jpg','3'),(8,'Punjabi food','./menu_images/1460787643342.jpg','4'),(9,'Deserts','./menu_images/1460787677162.jpg','5'),(10,'Sea food','./menu_images/1460787690250.jpg','5'),(11,'Punjabi food','./menu_images/1460787721713.jpg','6'),(12,'Bakingrecipies','./menu_images/1460787738516.jpg','6'),(13,'Deserts','./menu_images/1461561416164.jpg','8'),(14,'Snacks','./menu_images/1461561441661.jpg','8'),(15,'Punjabi Food','./menu_images/1461561477797.jpg','8'),(16,'Pizza','./menu_images/1461561505575.jpg','8'),(17,'Punjabi Food','./menu_images/1461561623791.jpg','1'),(18,'Snacks','./menu_images/1461561643623.jpg','1'),(19,'Salad','./menu_images/1461561666773.jpg','1'),(20,'Soft Drink','./menu_images/1461561721746.jpg','1'),(21,'Deserts','./menu_images/1461561757971.jpg','1'),(22,'Bakingrecipies','./menu_images/1461561817048.jpg','1'),(23,'Salad','./menu_images/1461561988449.jpg','2'),(24,'Pizza','./menu_images/1461563159219.jpg','3'),(25,'Deserts','./menu_images/1461563177347.jpg','3'),(26,'Salad','./menu_images/1461563210469.jpg','3'),(27,'Bakingrecipies','./menu_images/1461563261937.jpg','3'),(28,'Shakes','./menu_images/1461563294795.jpg','3'),(29,'Sea Food','./menu_images/1461563347351.jpg','3'),(30,'Soups','./menu_images/1461563384011.jpg','3'),(31,'Pizza','./menu_images/1461563664635.jpg','4'),(32,'Deserts','./menu_images/1461563701601.jpg','4'),(33,'Salad','./menu_images/1461563728552.jpg','4'),(34,'Bakingrecipies','./menu_images/1461564108505.jpg','4'),(35,'Shakes','./menu_images/1461564194620.jpg','4'),(36,'Soft Drink','./menu_images/1461564216598.jpg','4'),(37,'Gujrati Food','./menu_images/1461564594666.jpg','4'),(38,'Punjabi Food','./menu_images/1461564685843.jpg','5'),(39,'Salad','./menu_images/1461564703987.jpg','5'),(40,'Pizza','./menu_images/1461565066350.jpg','6'),(41,'Shakes','./menu_images/1461565343119.jpg','6'),(42,'Snacks','./menu_images/1461565365463.jpg','6'),(43,'Gujrati Food','./menu_images/1461565650926.jpg','7'),(44,'Soups','./menu_images/1461568196593.jpg','4'),(45,'Salad','./menu_images/1461569962133.jpg','7'),(51,'Salad','./menu_images/1461570305273.jpg','8'),(52,'Non veg','./menu_images/1461914994134.jpg','9'),(53,'Punjabi food','./menu_images/1461915034481.jpg','9'),(54,'Spicy food','./menu_images/1461915067354.jpg','9'),(55,'Punjabi food','./menu_images/1461915686084.jpg','10'),(56,'Salad','./menu_images/1461916805953.jpg','11'),(57,'Roles','./menu_images/1461916942448.jpg','11'),(58,'Pulao','./menu_images/1461993174570.jpg','12'),(59,'Lifo vegetables','./menu_images/1461993264072.jpg','12'),(60,'Rice and Noodles','./menu_images/1461993373300.jpg','12'),(61,'Appetizers Fried','./menu_images/1461994652412.jpg','13'),(62,'Delicious curries','./menu_images/1461994825901.jpg','13'),(63,'vegetable curries','./menu_images/1461995007478.jpg','13'),(64,'Deserts','./menu_images/1462185160035.jpg','2'),(65,'Snacks','./menu_images/1462185428659.jpg','2'),(69,'Sweet Dishes','./menu_images/1462341976866.jpg','14'),(70,'Meat Dishes','./menu_images/1462342283682.jpg','14'),(71,'Vegetables','./menu_images/1462342542344.jpg','14'),(72,'Meat and Poultry','./menu_images/1462345406521.jpg','16'),(73,'Curries/Gravies ','./menu_images/1462345849188.jpg','16'),(74,'Pickles and Condiments','./menu_images/1462346161486.jpg','16'),(75,'Pasta and Grains','./menu_images/1462347519621.jpg','16'),(76,'Indian Breads','./menu_images/1462347984559.jpg','16'),(77,'Meat Dishes','./menu_images/1462348269394.jpg','15'),(78,'Deserts','./menu_images/1462348504758.jpg','15'),(79,'Snacks','./menu_images/1462348621747.jpg','15'),(80,'Vegetables','./menu_images/1462348856465.jpg','15'),(81,'demo_menu','./menu_images/1462350934602.jpg','17');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_item`
--

DROP TABLE IF EXISTS `menu_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_item` (
  `m_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(400) NOT NULL,
  `veg_or_nonveg` varchar(500) NOT NULL,
  `display_price` varchar(45) NOT NULL,
  `offer_price` varchar(45) NOT NULL,
  `restaurant_name` varchar(400) NOT NULL,
  `menu_name` varchar(400) NOT NULL,
  PRIMARY KEY (`m_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_item`
--

LOCK TABLES `menu_item` WRITE;
/*!40000 ALTER TABLE `menu_item` DISABLE KEYS */;
INSERT INTO `menu_item` VALUES (1,'Tomato Soup','veg','125','99','Tej food Grand','Soups'),(2,'Mixed veg Soup','veg','150','130','Tej food grand','Soups'),(3,'Meggi Soup','veg','100','80','Crystal Restaurant','Soups'),(4,'Sweet Corn Soup','veg','160','140','Crystal Restaurant','Soups'),(5,'Cheese with mushroom pizza','veg','200','180','Crystal Restaurant','Pizza'),(6,'Mixed veg pizza','veg','299','250','Crystal Restaurant','Pizza'),(7,'Tomato & onion pizza','veg','240','199','Tej food grand','Pizza'),(8,'Olives and capsicum pizza','veg','260','200','Tej food grand','Pizza'),(9,'Star fish','nonveg','300','280','Crystal restaurant','Sea food'),(10,'Prowns','nonveg','350','330','Crystal restaurant','Sea food'),(11,'Crab','nonveg','400','440','Tej food grand','Sea food'),(12,'Snails','nonveg','380','340','Sagar Ratan Restaurant','Sea food'),(13,'Fish','nonveg','380','350','Sagar Ratan Restaurant','Sea food'),(14,'Appy pie','veg','200','170','Crystal Restaurant','Bakingrecipies'),(15,'Blueberry cake','veg','300','260','Brothers Dhaba','Bakingrecipies'),(16,'Muffons','nonveg','200','180','Tej food grand','Bakingrecipies'),(17,'Chocolate cake','veg','350','300','New kundan ','Bakingrecipies'),(18,'Dal makhni','veg','200','180','Brothers Dhaba','Punjabi food'),(19,'Rajma chawal','veg','280','220','Tej food grand','Punjabi food'),(20,'Lacha parantta','veg','150','120',' Tej food grand','Punjabi food'),(21,'Curry chawal','veg','290','260','New kundan ','Punjabi food'),(22,'Makki di roti te sarson da saag','veg','400','350','Brothers Dhaba','Punjabi food'),(23,'Neutri kulcha','veg','200','140','Sagar Ratan Restaurant','Punjabi food'),(24,'kadai paneer','veg','400','340','Grandway restaurant','Punjabi food'),(25,'Mashroom masala','veg','300','240','Brothers Dhaba','Punjabi food'),(26,'Tandoori naan with chicken','nonveg','500','440','Grandway restaurant','Punjabi food'),(27,'Spring roll','veg','150','130','Brothers Dhaba','Snacks'),(28,'Momos','veg','200','160','Tej food grand','Snacks'),(29,'Manchurian','veg','230','200','Tej food grand','Snacks'),(30,'Manchurian','veg','200','180','Brothers Dhaba','Snacks'),(31,'French fries','veg','160','140','Crystal restaurant','Snacks'),(32,'Champs','veg','480','440','Crystal restaurant','Snacks'),(33,'Burger','veg','260','230','New kundan','Snacks'),(34,'Chowmin','veg','260','230','Grandway restaurant','Snacks'),(35,'Chowmin','veg','230','200','Sagar Ratan Restaurant','Snacks'),(36,'veg bullets','veg','240','200','Grandway  restaurant','Snacks'),(37,'vanilla icecream','veg','150','120','Crystal restaurant','Deserts'),(38,'Chocolate icecream','veg','200','150','Crystal restaurant','Deserts'),(39,'kheer','veg','300','250',' Brothers Dhaba','Deserts'),(40,'Strawbeery icecream','veg','200','160',' Brothers Dhaba','Deserts'),(41,'Gulab jamun','veg','180','130','Tej food grand','Deserts'),(42,'Butter Sctoch','veg','200','140','Tej food grand','Deserts'),(43,'Faluda kulffi','veg','160','120','Grandway restaurant','Deserts'),(44,'Cup ice cream','veg','200','140','New kundan','Deserts'),(45,'Gajrella','veg','300','280','Sagar Ratan Restaurant','Deserts'),(46,'Ras malai','veg','340','300','Sagar Ratan Restaurant','Deserts'),(47,'Dhokla','veg','200','140','Brothers Dhaba','Gujrati food'),(48,'Vegies','veg','300','240','Tej food grand','Gujarati food'),(49,'Naan','veg','140','120','Crystal restaurant','Gujarati food'),(50,'Cream salad','veg','250','230','Crystal restaurant','Salad'),(51,'Onion salad','veg','100','60','Brothers Dhaba','Salad'),(52,'Cucumber salad','veg','80','60','Sagar Ratan Restaurant','Salad'),(53,'MIxed fruit salad','veg','200','180','Tej food grand','Salad'),(54,'Tomato with Raddish','veg','140','120','New kundan','Salad'),(55,'Beet root','veg','270','200','Grandway restaurant','Salad'),(56,'Romio pizza','veg','300','250','Grandway restaurant','Pizza'),(57,'Juilet pizza','veg','280','240','Grandway restaurant','Pizza'),(58,'Strawberry shake','veg','200','160','Grandway restaurant','Shakes'),(59,'Chocolate shake','veg','200','130','Grandway restaurant','Shakes'),(60,'Mango  shake','veg','180','150','Brothers Dhaba','Shakes'),(61,'Banana shake','veg','160','130','Brothers Dhaba','Shakes'),(62,'Vanilla shake','veg','200','140','Crystal restaurant','Shakes'),(63,'Pepsi','veg','80','60','Brothers Dhaba','Soft drink'),(64,'frooti','veg','100','80','Tej food grand','Soft drink'),(65,'Mixed Veg Pizza','veg','150','140','Brothers Dhaba','Pizza'),(66,'Cheese Pizza','veg','270','240','Brothers Dhaba','Pizza'),(67,'Cheese Pizza','veg','270','240','MEHFIL-E-PUNJAB','Pizza'),(68,'Mixed Veg Pizza','veg','200','150','MEHFIL-E-PUNJAB','Pizza'),(69,'Strawberry shake','veg','160','150','MEHFIL-E-PUNJAB','Shakes'),(70,'Pasta','veg','160','150','MEHFIL-E-PUNJAB','Snacks'),(71,'Tikki','veg','80','60','MEHFIL-E-PUNJAB','Snacks'),(72,'Curry','veg','100','60','MEHFIL-E-PUNJAB','Punjabi Food'),(73,'Cookies','veg','80','60','MEHFIL-E-PUNJAB','Bakingrecipies'),(74,'MIxed Salad','veg','70','65','Sangam Restaurant','Salad'),(75,'Thali','veg','160','150','Sangam Restaurant','Gujrati Food'),(76,'Tomato Soup','veg','100','90','Brothers Dhaba','Soups'),(77,'Corn Soup','veg','160','150','Brothers Dhaba','Soups'),(78,'Icecream','veg','70','60','Brothers Dhaba','Deserts'),(79,'Dum aloo','veg','160','150','Haveli','Punjabi food'),(80,'Butter Chicken','nonveg','450','430','Haveli','Non veg'),(81,'Paneer chilli in choice of sauce','veg','100','90','Haveli','Spicy food'),(82,'Tandoori chicken','nonveg','500','480','Food Bazar','Punjabi food'),(83,'Malyi kofta','veg','200','180','Food Bazar','Punjabi food'),(84,'Paneer tikka','veg','300','280','Food Bazar','Punjabi food'),(85,'Cream Salad','veg','150','145','Yellow Chilli','Salad'),(86,'Fruit Salad','veg','200','180','Yellow Chilli','Salad'),(87,'Mixed Salad','veg','225','200','Yellow Chilli','Salad'),(88,'Veg Roles','veg','275','250','Yellow Chilli','Roles'),(89,'Noodles Roles','veg','195','180','Yellow Chilli','Roles'),(90,'Mutton Roles','nonveg','445','440','Yellow Chilli','Roles'),(91,'kashmiri pulao','veg','325','310','Spice Cube','Pulao'),(92,'Vegetable Yakni Pulao','veg','430','410','Spice Cube','Pulao'),(93,'Mushroom Pulao','veg','275','260','Spice Cube','Pulao'),(94,'Vegetable five spices','veg','400','380','Spice Cube','Lifo vegetables'),(95,'Veg Manchurian','veg','155','145','Spice Cube','Lifo vegetables'),(96,'Vegetable Fried Rice','veg','400','380','Spice Cube','Rice and Noodles'),(97,'Chilly Garlic Noodle','veg','180','160','Spice Cube','Rice and Noodles'),(98,'Chilly Garlic Rice','veg','325','315','Spice Cube','Rice and Noodles'),(99,'Bamboo Rice','veg','400','390','Spice Cube','Rice and Noodles'),(100,'Samosa (3 pieces)','veg','60','56','Hot Millions','Appetizers Fried'),(101,'Onion Bhaji','veg','220','200','Hot Millions','Appetizers Fried'),(102,'Cheese Chilli','veg','220','200','Hot Millions','Appetizers Fried'),(103,'Aloo Tikki','veg','300','280','Hot Millions','Appetizers Fried'),(104,'Fish Pakora(5 pieces)','nonveg','480','470','Hot Millions','Appetizers Fried'),(105,'Chicken Pakora','nonveg','450','445','Hot Millions','Appetizers Fried'),(106,'Goat Curry','nonveg','700','685','Hot Millions','Delicious curries'),(107,'Butter Chicken','nonveg','800','750','Hot Millions','Delicious curries'),(108,'Korma','nonveg','700','680','Hot Millions','Delicious curries'),(109,'Chicken Tikka Masala','nonveg','500','495','Hot Millions','Delicious curries'),(110,'Palak Paneer','veg','335','315','Hot Millions','vegetable curries'),(111,'Dal Makhni','veg','220','210','Hot Millions','vegetable curries'),(112,'Channa Masala','veg','400','375','Hot Millions','vegetable curries'),(113,'Malai kofta','veg','390','375','Hot Millions','vegetable curries'),(114,'Balushai','veg','100','90','Chokni Dhani','Sweet Dishes'),(115,'Churma','veg','99','90','Chokni Dhani','Sweet Dishes'),(116,'Ghevar','veg','140','125','Chokni Dhani','Sweet Dishes'),(117,'Gujia','veg','130','125','Chokni Dhani','Sweet Dishes'),(118,'Milk cake(Alwar Ka Mawa)','veg','300','290','Chokni Dhani','Sweet Dishes'),(119,'Laal maaans(meat in red chilles curry)','nonveg','800','780','Chokni Dhani','Meat Dishes'),(120,'Safed maans(meat cooked in curd)','nonveg','700','685','Chokni Dhani','Meat Dishes'),(121,'Saanth ro achaar(pickled wild boar meat)','nonveg','785','750','Chokni Dhani','Meat Dishes'),(122,'Beans ki sabji','veg','400','390','Chokni Dhani','Vegetables'),(123,'Lauki ke Kofte','veg','550','540','Chokni Dhani','Vegetables'),(124,'Makki ki ghaat','veg','300','280','Chokni Dhani','Vegetables'),(125,'Chicken mirvani','nonveg','900','890','Bombay Blue','Meat and Poultry'),(126,'Kheema pav','nonveg','700','690','Bombay Blue','Meat and Poultry'),(127,'Amti','veg','400','390','Bombay Blue','Curries/Gravies '),(128,'kadhi','veg','200','190','Bombay Blue','Curries/Gravies '),(129,'Mango pickle','veg','450','440','Bombay Blue','Pickles and Condiments'),(130,'mixed veg pickle','veg','500','480','Bombay Blue','Pickles and Condiments'),(131,'Pudina with onion','veg','300','290','Bombay Blue','Pickles and Condiments'),(132,'American  chop suey','veg','800','780','Bombay Blue','Pasta and Grains'),(133,'Roomali roti(2 pieces)','veg','100','80','Bombay Blue','Indian Breads'),(134,'Butter naan','veg','120','110','Bombay Blue','Indian Breads'),(135,'Chicken farcha (fried chicken)','nonveg','700','680','Cheron','Meat Dishes'),(136,'Patra ni machhi (steamed fish wrapped in banana leaf)','nonveg','900','880','Cheron','Meat Dishes'),(137,'Tamota ni russ chaval (mutton cutlets with white rice and tomato sauce)','nonveg','1000','970','Cheron','Meat Dishes'),(138,'Ravo (semolina)','veg','150','130','Cheron','Deserts'),(139,'sev (vermicelli)','veg','200','190','Cheron','Deserts'),(140,'bhakhra (deep fried sweet dough)','veg','500','490','Cheron','Snacks'),(141,'khaman na ladva (dumplings stuffed with sweetened coconut)','veg','390','378','Cheron','Deserts'),(142,'Kadai Mushroom with Gravy','veg','330','310','Cheron','Vegetables'),(143,'Moong Sprouts chaat','veg','200','190','Cheron','Vegetables');
/*!40000 ALTER TABLE `menu_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_detail` (
  `order_detai_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `menu_item` varchar(400) NOT NULL,
  `item_price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL,
  PRIMARY KEY (`order_detai_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (4,2,'Mixed Veg Pizza',140,3,420),(5,2,'Cheese Pizza',240,2,480),(6,2,'Icecream',60,2,120),(7,2,'Onion salad',60,2,120),(8,2,'Blueberry cake',260,1,260),(9,2,'Mashroom masala',240,1,240),(10,2,'Banana shake',130,2,260),(11,2,'Mango  shake',150,2,300),(12,2,'Dal makhni',180,1,180),(13,4,'Dal makhni',180,2,360),(14,4,'Tomato Soup',90,1,90),(15,3,'Dal makhni',180,1,180),(16,5,'Icecream',60,3,180),(17,5,'Onion salad',60,2,120),(18,5,'Mashroom masala',240,2,480),(19,7,'Tomato Soup',99,1,99),(20,7,'Mixed veg Soup',130,1,130),(21,7,'Mixed veg Soup',130,6,780),(22,7,'Olives and capsicum pizza',200,2,400),(23,7,'Tomato & onion pizza',199,1,199),(24,8,'Curry',60,1,60),(25,8,'Cookies',60,1,60),(26,8,'Mixed Veg Pizza',150,1,150),(27,8,'Tikki',60,2,120),(28,9,'Dal makhni',180,1,180),(29,9,'Makki di roti te sarson da saag',350,1,350),(30,9,'Mashroom masala',240,1,240),(31,9,'Icecream',60,1,60),(32,9,'Onion salad',60,1,60),(33,10,'Curry',60,1,60),(34,10,'Cookies',60,1,60),(35,11,'Dal makhni',180,1,180),(36,11,'Makki di roti te sarson da saag',350,1,350),(37,11,'Mashroom masala',240,1,240);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant` (
  `restaurant_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `desc` varchar(500) NOT NULL,
  `image` varchar(400) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone_no` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `opening_time` varchar(45) NOT NULL,
  `closing_time` varchar(45) NOT NULL,
  `average_price` varchar(45) NOT NULL,
  `delivery_time` varchar(45) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`restaurant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES (1,'Tej Food Grand','spicy food','./restaurant_image/Tej food grand.jpg','Tarn-taran by pass','98745621','Tarn Taran','10:00am','10:00pm','200.00','30:00'),(2,'New kundan','delcious punjabi food','./restaurant_image/new kundan.jpg','albert road,near railway station','01832224276','Amritsar','8:00am',' 10:00pm','250','30:00'),(3,'Crystal Restaurant','clean,super fast survice','./restaurant_image/crystal restaurant.jpg','crystal chownk,near ram bagh','01832225555','Amritsar','11:00am','11:30pm','800','20:00'),(4,'Brothers Dhaba','all type of food ','./restaurant_image/Brothers Dhaba.jpg','katra jaimal singh','0183-464652','Amritsar','07:00am','11:00pm','300','30:00'),(5,'Sagar Ratan Restaurant','all type of food ','./restaurant_image/Sagar Ratan restaurant.jpg','queens road','0183-464653','Amritsar','07:00am','11:00pm','400','30:00'),(6,'MEHFIL-E-PUNJAB','full faculity of quick service and full of taste','./restaurant_image/MEHFIL-E-PUNAJB.jpg','abhohar fazilka highway','09780438500','Abohar','07:00am','11:00pm','150','30:00'),(7,'Sangam Restaurant','family style restaurant','./restaurant_image/Sangam Restaurant.jpg','Hanumangadh road','09780438400','Abohar','08:00am','12:00pm','200','30:00'),(8,'Grandway Restaurant','famous cuisine popular dishes','./restaurant_image/Grandway Reataurant.jpg','shastri nagar','09815488751','Batala','08:00am','10:00pm','500','40:00'),(9,'Haveli','Very good destination and amazing food....','./restaurant_image/Haveli.jpg','Grand trunk road','01824500154','Jalandhar','12:00am','12:00pm','200','20 mins'),(10,'Food Bazar','Hygenic place','./restaurant_image/Food Bazar.jpg','Madan floor mills compound,Ladowali road','01812238434','Jalandhar','01:00am','11:00pm','400','25 mins'),(11,'Yellow Chilli','Stylish chain restaurant serving Mughlai, Punjabi and dishes from India\'s Northwestern frontier.','./restaurant_image/Yellow Chilli.jpg',' 32C, SCF Sarabha Nagar, Main Market, Ludhiana, Punjab 141001','098555 23333','Ludhiana','11:00am','11:00pm','500','20min'),(12,'Spice Cube',' Cool ambience, yummy food.','./restaurant_image/Spice Cube.jpg','Kartar Bhawan, Near P.a.u. Gate No. 1, Ferozepur Road, Ludhiana, Punjab 141001',' 0161 4444450','Ludhiana','01:00am','11:00pm','600','30mins'),(13,'Hot Millions','Excellent service and food. Must try their hot choc fudge, walnut pies and kathis.','./restaurant_image/Hot Millions.jpg',' Sector 17 Road, Near Panasonic India Pvt. Ltd Sector 17, Chandigarh ','0172 2723000','Chandigarh','01:00am','11:00pm','1000','25 mins'),(14,'Chokni Dhani','pure Veg','./restaurant_image/Chokni Dhani.jpg','  Sector 2 â?º Chokhi Dhani Sector 2, Chandigarh, India address Amravati NH22 Mall, Amravati Enclave, Pinjore-Kalka Urban Complex, Sector 2, Panchkula 134105','01726670955','Chandigarh','05:30pm','11:00pm','550','30:00mins'),(15,'Cheron','Popular in parsi food','./restaurant_image/Cheron.jpg','Eureka\'s, Opposite St Joseph Convent, Hill Road, Bandra West, Mumbai',' 022 65043809 ','Bombay','09:30am','09:30pm','900','20 mins'),(16,'Bombay Blue','Special in Maharastrian food','./restaurant_image/Bombay Blue.jpg',' Fort â?º Bombay Blue Fort, Mumbai, India address 18, Har Govindas Building, K Dubhas Marg, Kala Ghoda, Fort, Mumbai','022 61344965 ','Bombay','11:00am','11:00pm','1000','30 mins');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_menu`
--

DROP TABLE IF EXISTS `restaurant_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `cuisine_name` varchar(45) NOT NULL,
  `r_id` int(11) NOT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_menu`
--

LOCK TABLES `restaurant_menu` WRITE;
/*!40000 ALTER TABLE `restaurant_menu` DISABLE KEYS */;
INSERT INTO `restaurant_menu` VALUES (1,'chinese',1),(2,'italian',1),(3,'punjabi food',2),(4,'north indian',2),(5,'south indian',3),(6,'chinese',3),(7,'indian',4),(8,'chinese',5),(9,'italian',5),(10,'punjabi food',6),(11,'indian',7),(12,'punjabi food',8),(13,'indian',8),(14,'italian',8),(15,'punjabi food',9),(16,'punjabi food',10),(17,'indian',10),(18,'chinese',10),(19,'indian',11),(20,'chinese',11),(21,'chinese',12),(22,'indian',12),(23,'chinese',13),(24,'indian',13),(25,'Rajasthani',14),(26,'North indian',15),(27,'Parsi',15),(28,'italian American',16),(29,'indian',16),(30,'Maharastrian',16),(31,'punjabi food',4);
/*!40000 ALTER TABLE `restaurant_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `rest_id` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `review` varchar(500) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'prabhjot.beas@gmail.com',1,5,'hellow world','2016-05-09 06:35:11');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `email` varchar(300) NOT NULL,
  `password` varchar(300) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Manpreet Kaur','mkjohal94@gmail.com','123','12345'),(2,'Prabhjot kaur','prabhjot.beas@gmail.com','sweetgolu','67890'),(3,'Sandeep Kaur','sandeep.mandeep@gmail.com','1234','123456'),(8,'demo','demo@gmail.com','abcdef','123'),(9,'Harman','Hsingh@gmail.com','1234','98722'),(10,'Ritiraj','sharma@gmail.com','jija','98790');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_order`
--

DROP TABLE IF EXISTS `user_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(200) NOT NULL,
  `amount` varchar(400) DEFAULT NULL,
  `coupen` varchar(500) DEFAULT NULL,
  `discount` varchar(400) DEFAULT NULL,
  `payable` varchar(400) DEFAULT NULL,
  `status` varchar(400) DEFAULT 'pending',
  `reviewed` varchar(5) DEFAULT 'no',
  `rest_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_order`
--

LOCK TABLES `user_order` WRITE;
/*!40000 ALTER TABLE `user_order` DISABLE KEYS */;
INSERT INTO `user_order` VALUES (7,'prabhjot.beas@gmail.com','229',NULL,NULL,'229','pending','yes',1),(8,'prabhjot.beas@gmail.com','1379',NULL,NULL,'1379','pending','no',1),(9,'prabhjot.beas@gmail.com','390',NULL,NULL,'390','pending','no',11),(10,'prabhjot.beas@gmail.com','890','No Coupon Applied','0','890','pending','no',4),(11,'prabhjot.beas@gmail.com','120','No Coupon Applied','0','120','pending','no',6),(12,'prabhjot.beas@gmail.com','770','No Coupon Applied','0','770','pending','no',1);
/*!40000 ALTER TABLE `user_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-12 10:55:07
