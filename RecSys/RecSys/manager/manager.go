package manager

import (
	"errors"
	"fmt"
	"github.com/google/uuid"
	"math"
	"sort"
	"time"
)

type Dish struct {
	ID         string    `json:"id"`
	Name       string    `json:"name"`
	TableID    int       `json:"table_id"`
	Time       time.Time `json:"time"`
	CookedTime time.Time
}

type Order struct {
	Dishes []Dish `json:"dishes"`
}

type Manager struct {
	DishDict map[string][]Dish
	Cooked   map[string]Dish
}

func (m *Manager) AddOrder(order Order) error {
	for _, dish := range order.Dishes {
		dish.ID = uuid.New().String()
		m.DishDict[dish.Name] = append(m.DishDict[dish.Name], dish)
	}

	fmt.Println(m.DishDict)

	return nil
}

func (m *Manager) CookDish(dishName string, dishNum int) error {
	if _, ok := m.DishDict[dishName]; !ok {
		return errors.New("dish not found")
	}
	if len(m.DishDict[dishName]) < dishNum {
		return errors.New("dish num is zero")
	}

	for i := 0; i < dishNum; i++ {
		m.DishDict[dishName][i].CookedTime = time.Now()
		m.Cooked[m.DishDict[dishName][i].ID] = m.DishDict[dishName][i]
	}

	m.DishDict[dishName] = m.DishDict[dishName][dishNum:]
	return nil
}

func (m *Manager) ServeCooked(serveID string) {
	delete(m.Cooked, serveID)
}

func (m *Manager) GetCookList() []Dish {
	list := make([]Dish, 0, len(m.Cooked))
	for _, v := range m.Cooked {
		list = append(list, v)
	}

	sort.Slice(list, func(i, j int) bool {
		return list[i].CookedTime.Before(list[j].CookedTime)
	})

	return list
}

type DishEntry struct {
	DishName string    `json:"dish_name"`
	WaitNum  int       `json:"wait_num"`
	WaitArr  []float64 `json:"wait_arr"`
	Score    float64   `json:"score"`
}

func (m *Manager) GetRec() []DishEntry {
	var dishEntries []DishEntry

	for dishName, dishes := range m.DishDict {
		entry := DishEntry{
			DishName: dishName,
			WaitNum:  len(dishes),
			Score:    0,
		}

		for _, dish := range dishes {
			waitTime := time.Since(dish.Time).Minutes()
			entry.WaitArr = append(entry.WaitArr, waitTime)
			entry.Score += math.Pow(waitTime, 1.2)
		}
		dishEntries = append(dishEntries, entry)
	}

	sort.Slice(dishEntries, func(i, j int) bool {
		return dishEntries[i].Score > dishEntries[j].Score
	})

	return dishEntries
}
