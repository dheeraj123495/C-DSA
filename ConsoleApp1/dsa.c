#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_USERS 100
#define MAX_TOURNAMENTS 100
#define USER_FILE "users.txt"
#define TOURNAMENT_FILE "tournaments.txt"

typedef struct
{
    char username[50];
    char password[50];
    char selectedGame[50];
} User;

typedef struct
{
    char game[50];
    char name[50];
    double entryFee;
} Tournament;

User users[MAX_USERS];
int userCount = 0;

Tournament tournaments[MAX_TOURNAMENTS];
int tournamentCount = 0;

// Function Prototypes
void registerUser();
int loginUser();
void listTournaments(const char *game);
void createTournament();
void saveUsersToFile();
void loadUsersFromFile();
void saveTournamentsToFile();
void loadTournamentsFromFile();
void selectGame(User *user);
void changeGame(User *user);
void welcomeUser(const char *username);
int isTournamentAvailableForGame(const char *game);

int main()
{
    loadUsersFromFile();
    loadTournamentsFromFile();

    int option;
    while (1)
    {
        printf("\nWelcome to Battle Ground League!\n");
        printf("===============================\n");
        printf("1. Register\n");
        printf("2. Login\n");
        printf("3. Exit\n");
        printf("Choose an option: ");
        scanf("%d", &option);
        getchar(); // Clear newline

        switch (option)
        {
        case 1:
            registerUser();
            break;
        case 2:
            if (loginUser())
            {
                User *currentUser = &users[userCount - 1]; // Using the last user who logged in
                welcomeUser(currentUser->username);
                int tournamentOption;
                while (1)
                {
                    printf("\n*** Tournament Options for %s ***\n", currentUser->selectedGame);
                    printf("1. List Tournaments\n");
                    printf("2. Create Tournament\n");
                    printf("3. Change Game\n");
                    printf("4. Logout\n");
                    printf("Choose an option: ");
                    scanf("%d", &tournamentOption);
                    getchar(); // Clear newline

                    if (tournamentOption == 1)
                    {
                        listTournaments(currentUser->selectedGame);
                    }
                    else if (tournamentOption == 2)
                    {
                        createTournament();
                    }
                    else if (tournamentOption == 3)
                    {
                        changeGame(currentUser);
                    }
                    else if (tournamentOption == 4)
                    {
                        break;
                    }
                    else
                    {
                        printf("Invalid option! Please try again.\n");
                    }
                }
            }
            break;
        case 3:
            printf("Exiting the application. Thank you for playing!\n");
            exit(0);
        default:
            printf("Invalid option! Please try again.\n");
        }
    }

    return 0;
}

void registerUser()
{
    if (userCount >= MAX_USERS)
    {
        printf("User limit reached.\n");
        return;
    }

    User newUser;
    printf("Enter username: ");
    fgets(newUser.username, sizeof(newUser.username), stdin);
    strtok(newUser.username, "\n"); // Remove newline

    printf("Enter password: ");
    fgets(newUser.password, sizeof(newUser.password), stdin);
    strtok(newUser.password, "\n"); // Remove newline

    selectGame(&newUser); // Allow user to select a game

    users[userCount++] = newUser;
    saveUsersToFile();
    printf("Registration successful!\n");
    welcomeUser(newUser.username); // Welcome the user after registration
}

void welcomeUser(const char *username)
{
    printf("\n*************************************\n");
    printf("****  Welcome, %s!  ****\n", username);
    printf("**** Enjoy your time in the Battle Ground League! ****\n");
    printf("*************************************\n");
}

void selectGame(User *user)
{
    printf("Select your game:\n");
    printf("1. BGMI\n");
    printf("2. Free Fire\n");
    printf("3. Call of Duty\n");
    printf("Choose an option: ");

    int gameOption;
    scanf("%d", &gameOption);
    getchar(); // Clear newline

    switch (gameOption)
    {
    case 1:
        strcpy(user->selectedGame, "BGMI");
        break;
    case 2:
        strcpy(user->selectedGame, "Free Fire");
        break;
    case 3:
        strcpy(user->selectedGame, "Call of Duty");
        break;
    default:
        printf("Invalid choice, defaulting to 'No Game'.\n");
        strcpy(user->selectedGame, "No Game");
        break;
    }
}

int loginUser()
{
    char username[50], password[50];
    printf("Enter username: ");
    fgets(username, sizeof(username), stdin);
    strtok(username, "\n"); // Remove newline

    printf("Enter password: ");
    fgets(password, sizeof(password), stdin);
    strtok(password, "\n"); // Remove newline

    for (int i = 0; i < userCount; i++)
    {
        if (strcmp(users[i].username, username) == 0 && strcmp(users[i].password, password) == 0)
        {
            printf("Login successful! Selected game: %s\n", users[i].selectedGame);
            return 1; // Successful login
        }
    }

    printf("Invalid credentials. Please try again.\n");
    return 0; // Unsuccessful login
}

void changeGame(User *user)
{
    printf("Current game: %s\n", user->selectedGame);
    selectGame(user); // Allow the user to select a new game
    printf("Game changed successfully to: %s\n", user->selectedGame);
}

void listTournaments(const char *game)
{
    int found = 0;
    printf("Available Tournaments for %s:\n", game);
    for (int i = 0; i < tournamentCount; i++)
    {
        if (strcmp(tournaments[i].game, game) == 0)
        {
            printf("%s - Entry Fee: $%.2f\n", tournaments[i].name, tournaments[i].entryFee);
            found = 1;
        }
    }
    if (!found)
    {
        printf("No tournaments available for %s.\n", game);
    }
}

void createTournament()
{
    if (tournamentCount >= MAX_TOURNAMENTS)
    {
        printf("Tournament limit reached.\n");
        return;
    }

    Tournament newTournament;
    printf("Enter tournament name: ");
    fgets(newTournament.name, sizeof(newTournament.name), stdin);
    strtok(newTournament.name, "\n"); // Remove newline

    printf("Enter the game for the tournament (BGMI, Free Fire, Call of Duty): ");
    fgets(newTournament.game, sizeof(newTournament.game), stdin);
    strtok(newTournament.game, "\n"); // Remove newline

    printf("Enter entry fee: ");
    scanf("%lf", &newTournament.entryFee);
    getchar(); // Clear newline

    tournaments[tournamentCount++] = newTournament;
    saveTournamentsToFile();
    printf("Tournament created successfully!\n");
}

void saveUsersToFile()
{
    FILE *file = fopen(USER_FILE, "w");
    if (!file)
    {
        printf("Error saving users to file.\n");
        return;
    }
    for (int i = 0; i < userCount; i++)
    {
        fprintf(file, "%s,%s,%s\n", users[i].username, users[i].password, users[i].selectedGame);
    }
    fclose(file);
}

void loadUsersFromFile()
{
    FILE *file = fopen(USER_FILE, "r");
    if (!file)
        return;

    while (fscanf(file, "%49[^,],%49[^,],%49[^\n]\n", users[userCount].username, users[userCount].password, users[userCount].selectedGame) == 3)
    {
        userCount++;
    }
    fclose(file);
}

void saveTournamentsToFile()
{
    FILE *file = fopen(TOURNAMENT_FILE, "w");
    if (!file)
    {
        printf("Error saving tournaments to file.\n");
        return;
    }
    for (int i = 0; i < tournamentCount; i++)
    {
        fprintf(file, "%s,%s,%.2f\n", tournaments[i].game, tournaments[i].name, tournaments[i].entryFee);
    }
    fclose(file);
}

void loadTournamentsFromFile()
{
    FILE *file = fopen(TOURNAMENT_FILE, "r");
    if (!file)
        return;

    while (fscanf(file, "%49[^,],%49[^,],%lf\n", tournaments[tournamentCount].game, tournaments[tournamentCount].name, &tournaments[tournamentCount].entryFee) == 3)
    {
        tournamentCount++;
    }
    fclose(file);
}
