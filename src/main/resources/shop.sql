--
-- Veritabanı: `ecommerce`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `shop`
--

CREATE TABLE `shop` (
  `shop_id` int(20) NOT NULL,
  `shop_name` varchar(200) NOT NULL,
  `shop_adress` varchar(2000) NOT NULL,
  `shop_phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `shop`
--

INSERT INTO `shop` (`shop_id`, `shop_name`, `shop_adress`, `shop_phone`) VALUES
(12, 'asd', 'asdsd', 'aaaaa'),
(15, 'orhan', '11111111111111', 'i?lkjh');

--
-- Dökümü yapılmış tablolar için indeksler
--

