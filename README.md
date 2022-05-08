# Small Hotel Reservation System

## Model UML diagram

[![](https://mermaid.ink/img/pako:eNqNk01PAjEQhv9K0yNhiV43hgSDB6NGAnjbS7cdoLHbbvqhIch_d_ZDKVCUHrqdzjPvzHbaHeVGAM0pV8y5qWRry6pCExxCWuBeGk3ul91Oy5BJ6bxl3E-CkJ6VCsiuczdjyjwgaAG_ojFOXSjhX4yQKxn796kEM7BOurMUsydCpEjEzcGB_WBtyRH_bDhTfV0b4O-P-rLvNfiUsDFVrLjwVuo1ITpUJdgLActtDakgAY5bWTdVJhRZlTqRN_yxlBZUTKrDdmmMAoYm6ObQxF_68W6NOT6Njfg5ChFicT6qppvPLwDJsq8xSTauC4lbcwIfVHq0OexrmILejEa3BSV3WTburAFacapTenBEN7G_nTqgrflPAW1DrmGuKpIOaQUWeynwIbZtLqjfALaK5rgUsGJB-YIWeo9oqAVe2AdMZizNV0w5GFIWvFlsNae5twF-oP4999T-G82ENRQ)](https://mermaid.live/edit#pako:eNqNk01PAjEQhv9K0yNhiV43hgSDB6NGAnjbS7cdoLHbbvqhIch_d_ZDKVCUHrqdzjPvzHbaHeVGAM0pV8y5qWRry6pCExxCWuBeGk3ul91Oy5BJ6bxl3E-CkJ6VCsiuczdjyjwgaAG_ojFOXSjhX4yQKxn796kEM7BOurMUsydCpEjEzcGB_WBtyRH_bDhTfV0b4O-P-rLvNfiUsDFVrLjwVuo1ITpUJdgLActtDakgAY5bWTdVJhRZlTqRN_yxlBZUTKrDdmmMAoYm6ObQxF_68W6NOT6Njfg5ChFicT6qppvPLwDJsq8xSTauC4lbcwIfVHq0OexrmILejEa3BSV3WTburAFacapTenBEN7G_nTqgrflPAW1DrmGuKpIOaQUWeynwIbZtLqjfALaK5rgUsGJB-YIWeo9oqAVe2AdMZizNV0w5GFIWvFlsNae5twF-oP4999T-G82ENRQ)

## Mermaid diagram

```mermaid
classDiagram
    direction BT
    class AbstractAuditable {
        Date  createdDate
        Date  lastModifiedDate
    }
    class AbstractPersistable {
        PK  id
    }
    class Reservation {
        LocalDate  checkIn
        LocalDate  checkOut
    }
    class Room {
        String  number
    }
    class RoomType {
        String  description
        String  name
    }
    class User {
        String  email
        boolean  enabled
        String  name
        String  password
        Role  role
    }
    
    AbstractAuditable  --|>  AbstractPersistable 
    Reservation  --|>  AbstractAuditable 
    Room  --|>  AbstractAuditable 
    Room "0..1" <--> "0..*" Reservation 
    Room "0..*" <--> "0..1" RoomType 
    RoomType  --|>  AbstractAuditable 
    User  --|>  AbstractAuditable 
    User "0..1" <--> "0..*" Reservation 

```