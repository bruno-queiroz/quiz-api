CREATE TABLE "quiz" (
    "id" TEXT NOT NULL,
    "answer" CHAR NOT NULL,
    "A" TEXT NOT NULL,
    "B" TEXT  NOT NULL,
    "C" TEXT NOT NULL,
    "D" TEXT NOT NULL,
    "createdAt" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT "quiz_pkey" PRIMARY KEY ("id")
);