defmodule HouseBuilder do
    
    def build, do: %House{}

    def add_room(house, room) do
        %House{house | rooms: [room|house.rooms]}
    end

    def add_chimney(house, chimney) do
        %House{house | chimneys: [chimney|house.chimneys]}
    end
end

defmodule House do
  defstruct rooms: [], chimneys: []
end

defmodule Room do
    defstruct width: 0, height: 0
end

defmodule Chimney do
    defstruct height: 0
end

defmodule MyHouse do
    house = HouseBuilder.build()
        |> add_room(%Room{width: 10, height: 20})
        |> add_room(%Room{width: 50, height: 80})
        |> add_room(%Room{width: 5, height: 5})
        |> add_room(%Room{width: 100, height: 100})
        |> add_chimney(%Chimney{height: 10})
end