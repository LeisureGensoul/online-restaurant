package invoker

import "RecSys/manager"

var Manager manager.Manager

func Init() {
	Manager = manager.Manager{
		DishDict: map[string][]manager.Dish{},
		Cooked:   map[string]manager.Dish{},
	}
}
