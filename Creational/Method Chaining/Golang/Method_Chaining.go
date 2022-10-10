package main

import (
	"fmt"
)

type Player_Stat struct {
	GamesPlayed  float64
	GoalScored   float64
	ShotOnTarget float64
	Assist       float64
}

func (s *Player_Stat) GoalsRatio(goals, gamesplayed float64) *Player_Stat {
	s.GoalScored = goals
	s.GamesPlayed = gamesplayed

	Goalsratio := s.GoalScored / s.GamesPlayed
	fmt.Printf("\nPlayer goal ratio is : %f", Goalsratio)
	return s

}

func (s *Player_Stat) SOT_Ratio(Sot float64) *Player_Stat {
	s.ShotOnTarget = Sot
	sotRatio := float64(s.ShotOnTarget / s.GamesPlayed)
	println(s.ShotOnTarget)

	fmt.Printf("\nThe player shot on target ratio is : %f", sotRatio)

	return s
}

func (s *Player_Stat) AssistRatio(assist float64) {

	s.Assist = assist

	AssistRatio := s.Assist / s.GamesPlayed

	fmt.Printf("\nThe assist ratio is : %f", AssistRatio)
}

func main() {
	ps := Player_Stat{}
	ps.GoalsRatio(20, 40).SOT_Ratio(55).AssistRatio(15)
}
