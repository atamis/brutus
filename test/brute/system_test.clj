(ns brute.system-test
    (:use [midje.sweet]
          [brute.entity]
          [brute.system]))

(def system (atom 0))

(defn- setup!
    "Provides setup for the tests. Has side effects"
    []
    (reset! system (create-system)))

(defn- r! [s] (reset! system s))

(namespace-state-changes (before :facts (setup!)))

(defrecord Position [x y])
(defrecord Velocity [x y])

(fact "You can add system functions, and then call them per game tick"
      (let [counter (atom 0)
            sys-fn (fn [delta] (swap! counter inc))]
          (process-one-game-tick @system 10)
          @counter => 0

          (println @system)

          (-> @system
              (add-system-fn sys-fn)
              r!)

          (println @system)

          (process-one-game-tick @system 10)
          @counter => 1

          (-> @system
              (add-system-fn sys-fn)
              r!)

          (process-one-game-tick @system 10)
          @counter => 3))