insert into vozilo ( markavozila_id, modelvozila_id, klasavozila_id, tipgoriva_id, vrstamenjaca_id, predjenikm, brsedistadeca, cdw, user_id, uoglasu) values ( 'Marka1','Model1','Klasa1','Gorivo1','Menjac1','100','4',true, 2,true);
insert into vozilo ( markavozila_id, modelvozila_id, klasavozila_id, tipgoriva_id, vrstamenjaca_id, predjenikm, brsedistadeca, cdw, user_id, uoglasu) values ( 'Marka2','Model2','Klasa2','Gorivo2','Menjac2','200','2',true, 3,true);
insert into vozilo ( markavozila_id, modelvozila_id, klasavozila_id, tipgoriva_id, vrstamenjaca_id, predjenikm, brsedistadeca, cdw, user_id, uoglasu) values ( 'Marka3','Model3','Klasa3','Gorivo3','Menjac3','300','2',true, 2,false);

insert into oglas ( user_id, vozilo_id, mesto, cena, popust, cenaspopust, slobodanod, slobodando,oddat,dodat) values ( 2, 1, 'Ugljevik', 10, 10, 10,'2020-06-24T19:00', '2020-08-26T20:00' ,'2020-06-24T13:47:52.265056100','2020-08-26T13:47:52.265056100');
insert into oglas ( user_id, vozilo_id, mesto, cena, popust, cenaspopust, slobodanod, slobodando,oddat,dodat) values ( 3, 2, 'Novi Sad', 20, 20, 20,'2020-06-12T19:00', '2020-08-22T20:00' ,'2020-06-12T13:47:52.265056100','2020-08-22T13:47:52.265056100');

insert into vozilo ( markavozila_id, modelvozila_id, klasavozila_id, tipgoriva_id, vrstamenjaca_id, predjenikm, brsedistadeca, cdw, user_id, uoglasu) values ( 'Marka4','Model4','Klasa4','Gorivo4','Menjac4','400','4',true, 3,true);
insert into vozilo ( markavozila_id, modelvozila_id, klasavozila_id, tipgoriva_id, vrstamenjaca_id, predjenikm, brsedistadeca, cdw, user_id, uoglasu) values ( 'Marka5','Model5','Klasa5','Gorivo5','Menjac5','500','2',true, 2,true);
insert into vozilo ( markavozila_id, modelvozila_id, klasavozila_id, tipgoriva_id, vrstamenjaca_id, predjenikm, brsedistadeca, cdw, user_id, uoglasu) values ( 'Marka6','Model6','Klasa6','Gorivo6','Menjac6','600','4',true, 3,false);

insert into oglas ( user_id, vozilo_id, mesto, cena, popust, cenaspopust, slobodanod, slobodando,oddat,dodat) values ( 3, 4, 'Bijeljina', 10, 10, 10, '2020-06-21T19:00', '2020-09-26T20:00' ,'2020-06-21T13:47:52.265056100','2020-09-26T13:47:52.265056100');
insert into oglas ( user_id, vozilo_id, mesto, cena, popust, cenaspopust, slobodanod, slobodando,oddat,dodat) values ( 2, 5, 'Beograd', 20, 20, 20, '2020-06-18T19:00', '2020-08-26T20:00' ,'2020-06-18T13:47:52.265056100','2020-08-26T13:47:52.265056100');

insert into vozilo ( markavozila_id, modelvozila_id, klasavozila_id, tipgoriva_id, vrstamenjaca_id, predjenikm, brsedistadeca, cdw, user_id, uoglasu) values ( 'Marka7','Model7','Klasa7','Gorivo7','Menjac7','700','4',true, 2,true);
insert into oglas ( user_id, vozilo_id, mesto, cena, popust, cenaspopust, slobodanod, slobodando) values ( 2, 7, 'Sarajevo', 20, 20, 20 , '2020-06-14T19:00', '2020-08-22T20:00');

insert into vozilo ( markavozila_id, modelvozila_id, klasavozila_id, tipgoriva_id, vrstamenjaca_id, predjenikm, brsedistadeca, cdw, user_id, uoglasu) values ( 'Fiat','R8','old tajmer','dizel','automatski','6000','2',true, 2,true);	--Za izvestaje SOAP
insert into oglas ( user_id, vozilo_id, mesto, cena, popust, cenaspopust, slobodanod, slobodando) values ( 2, 8, 'Banja Luka', 120, 20, 20 , '2020-09-01T19:00', '2020-09-15T20:00');			--Za izvestaje SOAP

insert into izvestaj (predjeniKm, komentar, vozilo_id, zahtev_id) values ('125', 'Vozilo vraceno na vrijeme', 7, 10);

insert into terminzauzeca (zauzetod, zauzetdo, vehicle_id) values ('2020-06-24T19:00', '2020-06-26T20:00', 5);
insert into terminzauzeca (zauzetod, zauzetdo, vehicle_id) values ('2020-06-26T19:00', '2020-06-29T20:00', 7);
insert into terminzauzeca (zauzetod, zauzetdo, vehicle_id) values ('2020-07-22T19:00', '2020-07-24T20:00', 7);
insert into terminzauzeca (zauzetod, zauzetdo, vehicle_id) values ('2020-07-23T19:00', '2020-07-27T20:00', 7);
insert into terminzauzeca (zauzetod, zauzetdo, vehicle_id) values ('2020-09-2T19:00', '2020-09-10T20:00', 8);	--Za izvestaje SOAP

insert into cenovnik(owner,naziv,vaziod,dat) values(3,'prvi','2020-06-23T13:47:52.265056100','2020-06-23T13:47:52.265056100');