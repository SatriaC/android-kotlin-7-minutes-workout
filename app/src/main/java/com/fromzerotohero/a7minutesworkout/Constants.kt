package com.fromzerotohero.a7minutesworkout

object Constants {
    fun defaultExerciseList():ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()
        val jumpingJacks = ExerciseModel(
            1,
            "Jumping Jack",
            R.drawable.jumping_jack,
            false,
            false
        )
        exerciseList.add(jumpingJacks)

        val wallSit = ExerciseModel(
            2,
            "Wall Sit",
            R.drawable.wall_sit,
            false,
            false
        )
        exerciseList.add(wallSit)

        val pushUp = ExerciseModel(
            3,
            "Push Up",
            R.drawable.push_up,
            false,
            false
        )
        exerciseList.add(pushUp)

        val plank = ExerciseModel(
            4,
            "Plank",
            R.drawable.plank,
            false,
            false
        )
        exerciseList.add(plank)

        val sidePlank = ExerciseModel(
            5,
            "Side Plank",
            R.drawable.side_plank,
            false,
            false
        )
        exerciseList.add(sidePlank)

        val squat = ExerciseModel(
            6,
            "Squat",
            R.drawable.squat,
            false,
            false
        )
        exerciseList.add(squat)

        val stepUp = ExerciseModel(
            7,
            "Step Up",
            R.drawable.step_up,
            false,
            false
        )
        exerciseList.add(stepUp)

        return exerciseList
    }
}