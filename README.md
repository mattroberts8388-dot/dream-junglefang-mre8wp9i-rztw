# Jungle Fang

A tiny Fabric mod for Minecraft 1.20.1 that adds a single item called **Jungle Fang** that deals **8 attack damage**.

## You do NOT need Java installed

GitHub can build the `.jar` file for you for free, in the cloud. Just follow these steps.

### Step-by-step build guide

1. **Create a GitHub account** at https://github.com (free).
2. Click the **+** in the top-right and choose **New repository**. Give it any name, keep it Public or Private, and click **Create repository**.
3. On the new empty repository page, click the link that says **"uploading an existing file"**.
4. **Extract** the ZIP you downloaded (double-click it). This creates a folder with all the mod files inside.
5. **IMPORTANT (macOS users):** The `.github` folder is **hidden by default** and invisible in Finder. In Finder, press **Cmd + Shift + .** (period) to reveal hidden files. If you skip this, the build workflow will never be uploaded and **the build will never run.**
6. Open the extracted folder. Select **ALL files and folders INSIDE it** — including the hidden `.github` folder. **Do not drag the outer folder itself; drag its contents.**
7. Drag all those selected items into the GitHub upload page.
8. Scroll down and click **Commit changes**.
9. Click the **Actions** tab at the top of your repository.
10. Wait about **2 minutes** for the build to finish (green checkmark).
11. Click the completed build run, then scroll down to **Artifacts** and download **mod-jar**.
12. Unzip the downloaded artifact to get the `.jar` file.
13. Copy that `.jar` into your `.minecraft/mods/` folder (create the `mods` folder if it doesn't exist). Make sure you have the **Fabric Loader** and **Fabric API** installed for Minecraft 1.20.1.
14. Launch Minecraft with the Fabric profile and enjoy your Jungle Fang!

### macOS warning (read again)

On macOS the `.github` folder is invisible in Finder. **You must press Cmd + Shift + . before selecting files.** If the `.github` folder is not uploaded, GitHub has nothing telling it to build, so no `.jar` will ever appear.

## What the item does

- **Jungle Fang**: a melee weapon dealing 8 attack damage. Found in the Combat creative tab. Repairable with Jungle Logs.