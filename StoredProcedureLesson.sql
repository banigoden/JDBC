
create definer= 'root'@ 'localhost' PROCEDERE 'getCount' ()
BEGIN
    select count(*) from Users;
    select count(*) from Books;
END